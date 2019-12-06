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

import androidx.annotation.NonNull;
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
import com.webtomob.newsapp.R;
import com.webtomob.newsapp.model.Entry;
import com.webtomob.newsapp.model.Feed;
import com.webtomob.newsapp.utility.Utility;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ArrayList<Entry> newsList = new ArrayList<>();
    private RecyclerView newsRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        newsRecyclerView = root.findViewById(R.id.newsRecyclerView);

        settingData();

        return root;
    }


    private void settingData(){
        homeViewModel.getNews().observe(this, new Observer<Feed>() {
            @Override
            public void onChanged(Feed s) {
                newsList.addAll(s.getEntry());
                settingRecyclerView();

                /*Glide.with(getContext())
                        .asBitmap()
                        .load(s.getIcon())
                        .apply(RequestOptions.skipMemoryCacheOf(true))
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                        //  override for old devices with low memory
                        .apply(RequestOptions.overrideOf(500))
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Drawable drawable = new BitmapDrawable(getResources(), resource);
                                imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                imageview.setImageDrawable(drawable);
                            }
                        });

                String dateTime = Utility.changeDateFormat(s.getUpdated());
                dateTextView.setText(dateTime);*/

                Log.v(" data ... ", " entry ... " + s.getUpdated());
                Log.v(" data ... ", " title ... " + s.getTitle());
                Log.v(" data ... ", " Icon ... " + s.getIcon());
                Log.v(" data ... ", " author ... " + s.getEntry().get(0).getAuthor().getName());
                Log.v(" data ... ", " entry ... " + s.getEntry());
                Log.v(" data ... ", " entry ... " + s.getEntry());
            }
        });
    }


    private void settingRecyclerView(){
        Log.v("Size is ... ", newsList.size()+ " ");
        HomeAdpater inboxAdapter = new HomeAdpater(getContext(), newsList);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        newsRecyclerView.setAdapter(inboxAdapter);
    }

}