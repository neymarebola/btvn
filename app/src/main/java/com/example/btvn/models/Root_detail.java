package com.example.btvn.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Date;

public class Root_detail {
    public String document_id;
    public String title;
    public String description;
    public String published_date;
    public String origin_url;
    public Publisher publisher;
    public String template_type;
    public ArrayList<Section> sections;

    public Root_detail(String document_id, String title, String description, String published_date, String origin_url, Publisher publisher, String template_type, ArrayList<Section> sections) {
        this.document_id = document_id;
        this.title = title;
        this.description = description;
        this.published_date = published_date;
        this.origin_url = origin_url;
        this.publisher = publisher;
        this.template_type = template_type;
        this.sections = sections;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getOrigin_url() {
        return origin_url;
    }

    public void setOrigin_url(String origin_url) {
        this.origin_url = origin_url;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTemplate_type() {
        return template_type;
    }

    public void setTemplate_type(String template_type) {
        this.template_type = template_type;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
}
