package com.example.btvn.models;

public class Publisher{
    public String id;
    public String name;
    public String icon;

    public Publisher(String id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
