package com.example.btvn.models;

public class Markup {
    public int markup_type;
    public int start;
    public int end;
    public String href;

    public Markup(int markup_type, int start, int end, String href) {
        this.markup_type = markup_type;
        this.start = start;
        this.end = end;
        this.href = href;
    }

    public int getMarkup_type() {
        return markup_type;
    }

    public void setMarkup_type(int markup_type) {
        this.markup_type = markup_type;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
