package com.example.btvn.models;

public class Content{
    public String href;
    public PreviewImage preview_image;
    public int duration;

    public Content(String href, PreviewImage preview_image, int duration) {
        this.href = href;
        this.preview_image = preview_image;
        this.duration = duration;
    }

    public String getHref() {
        return href;
    }

    public PreviewImage getPreview_image() {
        return preview_image;
    }

    public int getDuration() {
        return duration;
    }
}