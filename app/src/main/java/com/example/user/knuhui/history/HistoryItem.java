package com.example.user.knuhui.history;

import android.graphics.drawable.Drawable;

public class HistoryItem {
    private String menu;
    private Drawable drawable;

    public void setMenu(String menu){
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public void setDrawable(Drawable drawable){
        this.drawable = drawable;
    }

    public Drawable getDrawable() {
        return drawable;
    }
}
