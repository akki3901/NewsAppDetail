package com.webtomob.newsapp.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.webtomob.newsapp.R;
import com.webtomob.newsapp.model.Entry;
import com.webtomob.newsapp.utility.Utility;

import java.util.List;

public class HomeAdpater extends RecyclerView.Adapter {

    List<Entry> newsList;
    private Context context;

    public HomeAdpater(Context context, List<Entry> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);

        return new NewsItem(v);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final NewsItem item = (NewsItem) holder;
        final Entry newsData = newsList.get(position);

        item.titleTextView.setText(newsData.getTitle());
        String dateTime = Utility.changeDateFormat((newsData.getUpdated()));
        item.dateTextView.setText(dateTime);
        item.descriptionTextView.setText("#" + newsData.getAuthor().getName());

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            item.contentTextView.setText(Html.fromHtml(newsData.getContent(),Html.FROM_HTML_MODE_LEGACY));
        } else {
            item.contentTextView.setText(Html.fromHtml(newsData.getContent()));
        }

        /*Glide.with(context)
                .asBitmap()
                .load(newsData.getId())
                .apply(RequestOptions.skipMemoryCacheOf(true))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                //  override for old devices with low memory
                .apply(RequestOptions.overrideOf(500))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        Drawable drawable = new BitmapDrawable(context.getResources(), resource);
                        item.imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        item.imageview.setImageDrawable(drawable);
                    }
                });*/
    }

    @Override
    public int getItemCount() {
        return (null != newsList ? newsList.size() : 0);
    }

    private class NewsItem extends RecyclerView.ViewHolder {
        TextView titleTextView, dateTextView, descriptionTextView, contentTextView;
        ConstraintLayout constraintLayout;

        NewsItem(View v) {
            super(v);
            this.titleTextView = v.findViewById(R.id.titleTextView);
            this.dateTextView = v.findViewById(R.id.dateTextView);
            this.descriptionTextView = v.findViewById(R.id.descriptionTextView);
            this.contentTextView = v.findViewById(R.id.contentTextView);

        }
    }
}
