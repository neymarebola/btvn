package com.example.btvn.models;

import java.util.ArrayList;
import java.util.Date;

public class Item{
    public String document_id;
    public String title;
    public String description;
    public String content_type;
    public Date published_date;
    public Publisher publisher;
    public String origin_url;
    public Avatar avatar;
    public ArrayList<Image> images;
    public Content content;

    public Item(String document_id, String title, String description, String content_type, Date published_date, Publisher publisher, String origin_url, Avatar avatar, ArrayList<Image> images, Content content) {
        this.document_id = document_id;
        this.title = title;
        this.description = description;
        this.content_type = content_type;
        this.published_date = published_date;
        this.publisher = publisher;
        this.origin_url = origin_url;
        this.avatar = avatar;
        this.images = images;
        this.content = content;
    }

    public String getDocument_id() {
        return document_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent_type() {
        return content_type;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getOrigin_url() {
        return origin_url;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public Content getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Item{" +
                "document_id='" + document_id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content_type='" + content_type + '\'' +
                ", published_date=" + published_date +
                ", publisher=" + publisher +
                ", origin_url='" + origin_url + '\'' +
                ", avatar=" + avatar +
                ", images=" + images +
                ", content=" + content +
                '}';
    }
}