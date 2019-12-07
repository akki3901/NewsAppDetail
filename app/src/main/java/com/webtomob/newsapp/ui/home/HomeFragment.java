package com.webtomob.newsapp.ui.home;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.snackbar.Snackbar;
import com.webtomob.newsapp.R;
import com.webtomob.newsapp.model.Entry;
import com.webtomob.newsapp.model.Feed;
import com.webtomob.newsapp.utility.Utility;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ArrayList<Entry> newsList = new ArrayList<>();
    private RecyclerView newsRecyclerView;
    private ConstraintLayout constraintLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        constraintLayout = root.findViewById(R.id.constraintLayout);
        newsRecyclerView = root.findViewById(R.id.newsRecyclerView);

        settingData();

        return root;
    }


    private void settingData(){
        if(Utility.isInternetAvailable(getContext())) {
            homeViewModel.getNews().observe(this, new Observer<Feed>() {
                @Override
                public void onChanged(Feed s) {
                    if(s != null) {
                        newsList.addAll(s.getEntry());
                        settingRecyclerView();
                    }
                }
            });
        }else{
            Toast.makeText(getContext(), getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }
    }


    private void settingRecyclerView(){
        HomeAdpater inboxAdapter = new HomeAdpater(getContext(), newsList);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        newsRecyclerView.setAdapter(inboxAdapter);
    }

}