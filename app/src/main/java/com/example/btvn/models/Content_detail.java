package com.example.btvn.models;

import java.util.ArrayList;

public class Content_detail {
    public String href;
    public String caption;
    public int duration;
    public PreviewImage preview_image;
    public String text;
    public ArrayList<Markup> markups;
    public String main_color;
    public int original_width;
    public int original_height;

    public Content_detail(String href, String caption, int duration, PreviewImage preview_image, String text, ArrayList<Markup> markups, String main_color, int original_width, int original_height) {
        this.href = href;
        this.caption = caption;
        this.duration = duration;
        this.preview_image = preview_image;
        this.text = text;
        this.markups = markups;
        this.main_color = main_color;
        this.original_width = original_width;
        this.original_height = original_height;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public PreviewImage getPreview_image() {
        return preview_image;
    }

    public void setPreview_image(PreviewImage preview_image) {
        this.preview_image = preview_image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Markup> getMarkups() {
        return markups;
    }

    public void setMarkups(ArrayList<Markup> markups) {
        this.markups = markups;
    }

    public String getMain_color() {
        return main_color;
    }

    public void setMain_color(String main_color) {
        this.main_color = main_color;
    }

    public int getOriginal_width() {
        return original_width;
    }

    public void setOriginal_width(int original_width) {
        this.original_width = original_width;
    }

    public int getOriginal_height() {
        return original_height;
    }

    public void setOriginal_height(int original_height) {
        this.original_height = original_height;
    }
}
