package com.example.btvn.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.btvn.DetailActivity;
import com.example.btvn.R;
import com.example.btvn.models.Image;
import com.example.btvn.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    Context context;
    List<Item> listItems;
    List<Image> imgs;

    public static final int VIDEO_ITEM = 1;
    public static final int OTHER_ITEM = 2;

    public ItemAdapter(Context context, List<Item> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        imgs = new ArrayList<>();
        if (viewType == VIDEO_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.video_item_layout, parent, false);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.image_item_layout, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = listItems.get(position);
        if (holder.title != null) {
            holder.title.setText(item.getTitle());
        }
        if (holder.publisher != null) {
            holder.publisher.setText(item.getPublisher().getName());
        }
        if (holder.published_date != null) {
            holder.published_date.setText(item.getPublished_date().toString());
        }
        if (item.getContent_type().equals("video")) {
            // neu la video, hien thi video
            Uri uri = Uri.parse(item.getContent().getHref());

            // sets the resource from the
            // videoUrl to the videoView
            holder.videoView.setVideoURI(uri);
            holder.videoView.seekTo(1);

            MediaController mediaController = new MediaController(context);

            // sets the anchor view
            // anchor view for the videoView
            mediaController.setAnchorView(holder.videoView);

            // sets the media player to the videoView
            mediaController.setMediaPlayer(holder.videoView);

            // sets the media controller to the videoView
            holder.videoView.setMediaController(mediaController);
        } else {
            // hien thi list hinh anh len tren recyclerview
            List<Image> tmp = new ArrayList<>();
            tmp = item.getImages();
            imgs = new ArrayList<>();
            if (tmp != null) {
                imgs.addAll(tmp);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                holder.imgRec.setLayoutManager(linearLayoutManager);
                ItemImagesAdapter itemImagesAdapter = new ItemImagesAdapter(context, imgs);
                holder.imgRec.setAdapter(itemImagesAdapter);
            }
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, publisher, published_date;
        RecyclerView imgRec; // hien thi list cac hinh anh
        VideoView videoView; // hien thi video

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            publisher = itemView.findViewById(R.id.tv_publisher);
            imgRec = itemView.findViewById(R.id.images_rec);
            videoView = itemView.findViewById(R.id.item_video);
            published_date = itemView.findViewById(R.id.tv_published_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, DetailActivity.class));
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (listItems.get(position).getContent_type().equals("video")) {
            return VIDEO_ITEM;
        } else {
            return OTHER_ITEM;
        }
    }
}
