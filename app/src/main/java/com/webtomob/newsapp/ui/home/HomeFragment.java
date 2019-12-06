package com.webtomob.newsapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.webtomob.newsapp.R;
import com.webtomob.newsapp.model.Feed;
import com.webtomob.newsapp.ui.splash.SplashActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        /*homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/



        homeViewModel.getNews().observe(this, new Observer<Feed>() {
            @Override
            public void onChanged(Feed s) {
                textView.setText(s.getEntry().get(0).getTitle());
                Log.v(" data ... ", " entry ... " + s.getEntry().get(0).getTitle());
                Log.v(" data ... ", " title ... " + s.getTitle());
                Log.v(" data ... ", " Icon ... " + s.getIcon());
                Log.v(" data ... ", " author ... " + s.getEntry().get(0).getAuthor().getName());
                Log.v(" data ... ", " entry ... " + s.getEntry());
                Log.v(" data ... ", " entry ... " + s.getEntry());
            }
        });


        return root;
    }





}