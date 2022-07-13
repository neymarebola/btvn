package com.example.btvn.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.btvn.R;
import com.example.btvn.WebviewActivity;
import com.example.btvn.models.Markup;
import com.example.btvn.models.PreviewImage;
import com.example.btvn.models.Section;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder> {
    Context context;
    List<Section> listSections;
    public static final int IMG_SECTION = 1;
    public static final int VIDEO_SECTION = 2;

    public SectionAdapter(Context context, List<Section> listSections) {
        this.context = context;
        this.listSections = listSections;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == IMG_SECTION) {
            View view = LayoutInflater.from(context).inflate(R.layout.section_text_item_layout, parent, false);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.section_video_item_layout, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Section section = listSections.get(position);
        // bai viet chua video
        if (section.getSection_type() == 2) {
            // preview image
            PreviewImage previewImage = section.getContent().getPreview_image();
            if (previewImage != null) {
                if (previewImage.getHref() != null) {
                    Glide.with(context).load(previewImage.getHref())
                            .centerCrop()
                            .placeholder(R.drawable.img_placeholder)
                            .into(holder.previewImage);
                }
            }
            // caption
            if (section.getContent().getCaption() != null) {
                holder.caption.setText(section.getContent().getCaption());
            }

            // href
            String href = section.getContent().getHref();
            if (href != null) {
                playVideo(href, holder.videoView);
            }

            // text
            String text = section.getContent().getText();
            SpannableString ss = new SpannableString("");
            if (text != null) {
                for (Markup markup : section.getContent().getMarkups()) {
                    int start = markup.start;
                    int end = markup.end;
                    ss = highLightText(text, start, end);
                    ClickableSpan clickableSpan = new ClickableSpan() {
                        @Override
                        public void onClick(@NonNull View view) {
                            String href = markup.getHref();
                            if (href != null && !href.isEmpty()) {
                                Intent intent = new Intent(context, WebviewActivity.class);
                                intent.putExtra("href", href);
                                context.startActivity(intent);
                            } else {
                                Toast.makeText(context, "link is not available", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void updateDrawState(@NonNull TextPaint ds) {
                            super.updateDrawState(ds);
                            ds.setUnderlineText(false);
                        }
                    };
                    ss.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

                holder.text.setText(ss);
                holder.text.setMovementMethod(LinkMovementMethod.getInstance());
            }

        } else {
            PreviewImage previewImage = section.getContent().getPreview_image();
            if (previewImage != null) {
                if (previewImage.getHref() != null) {
                    Glide.with(context).load(previewImage.getHref())
                            .centerCrop()
                            .placeholder(R.drawable.img_placeholder)
                            .into(holder.previewImage);
                }
            }
            if (section.getContent().getCaption() != null) {
                holder.caption.setText(section.getContent().getCaption());
            }

            // caption
            String href = section.getContent().getHref();
            if (href != null) {
                Glide.with(context).load(href).into(holder.mainImage);
            }

            String text = section.getContent().getText();
            SpannableString ss = new SpannableString("");
            if (text != null) {
                for (Markup markup : section.getContent().getMarkups()) {
                    int start = markup.start;
                    int end = markup.end;
                    ss = highLightText(text, start, end);
                    ClickableSpan clickableSpan = new ClickableSpan() {
                        @Override
                        public void onClick(@NonNull View view) {
                            String href = markup.getHref();
                            Intent intent = new Intent(context, WebviewActivity.class);
                            intent.putExtra("href", href);
                            context.startActivity(intent);
                        }

                        @Override
                        public void updateDrawState(@NonNull TextPaint ds) {
                            super.updateDrawState(ds);
                            ds.setUnderlineText(false);
                        }
                    };
                    ss.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                holder.text.setText(ss);
                holder.text.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    @Override
    public int getItemCount() {
        return listSections.size();
    }

    SpannableString highLightText(String text, int s, int e) {
        SpannableString ss = new SpannableString(text);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, s, e, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }

    void playVideo(String href, VideoView videoView) {
        Uri uri = Uri.parse(href);

        // sets the resource from the
        // videoUrl to the videoView
        videoView.setVideoURI(uri);
        videoView.seekTo(1);

        MediaController mediaController = new MediaController(context);

        // sets the anchor view
        // anchor view for the videoView
        mediaController.setAnchorView(videoView);

        // sets the media player to the videoView
        mediaController.setMediaPlayer(videoView);

        // sets the media controller to the videoView
        videoView.setMediaController(mediaController);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView previewImage, mainImage;
        TextView caption, text;
        VideoView videoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            previewImage = itemView.findViewById(R.id.preview_image);
            caption = itemView.findViewById(R.id.tv_caption);
            videoView = itemView.findViewById(R.id.video_view);
            text = itemView.findViewById(R.id.tv_content);
            mainImage = itemView.findViewById(R.id.main_image);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Section section = listSections.get(position);
        if (section.getSection_type() == 2) {
            return VIDEO_SECTION;
        } else {
            return IMG_SECTION;
        }
    }
}
