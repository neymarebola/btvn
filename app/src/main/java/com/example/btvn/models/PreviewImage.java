package com.example.btvn.models;

public class PreviewImage{
    public String href;
    public String main_color;
    public int width;
    public int height;

    public PreviewImage(String href, String main_color, int width, int height) {
        this.href = href;
        this.main_color = main_color;
        this.width = width;
        this.height = height;
    }

    public String getHref() {
        return href;
    }

    public String getMain_color() {
        return main_color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}