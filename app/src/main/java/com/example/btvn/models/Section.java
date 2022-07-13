package com.example.btvn.models;

public class Section {
    public int section_type;
    public Content_detail content;

    public Section(int section_type, Content_detail content) {
        this.section_type = section_type;
        this.content = content;
    }

    public int getSection_type() {
        return section_type;
    }

    public void setSection_type(int section_type) {
        this.section_type = section_type;
    }

    public Content_detail getContent() {
        return content;
    }

    public void setContent(Content_detail content) {
        this.content = content;
    }
}
