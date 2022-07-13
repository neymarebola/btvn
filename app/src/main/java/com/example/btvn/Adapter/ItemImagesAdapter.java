package com.example.btvn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.btvn.R;
import com.example.btvn.models.Image;

import java.util.List;

public class ItemImagesAdapter extends RecyclerView.Adapter<ItemImagesAdapter.ViewHolder> {
    Context context;
    List<Image> listImages;

    public ItemImagesAdapter(Context context, List<Image> listImages) {
        this.context = context;
        this.listImages = listImages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Image image = listImages.get(position);
        // load hinh anh vao imageView
        String url = image.getHref();
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.img_placeholder)
                .into(holder.singleImage);
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView singleImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            singleImage = itemView.findViewById(R.id.single_image);
        }
    }
}
