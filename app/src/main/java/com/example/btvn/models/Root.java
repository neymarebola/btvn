package com.example.btvn.models;

import java.util.ArrayList;

public class Root{
    public ArrayList<Item> items;

    public Root(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
