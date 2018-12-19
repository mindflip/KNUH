package com.example.user.knuhui.history;

import android.graphics.drawable.Drawable;

public class HistoryItem {

    private Drawable drawableIcon;
    private String menu;
    private Drawable drawable;

    public void setMenu(String menu){
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public Drawable getDrawableIcon() {
        return drawableIcon;
    }

    public void setDrawableIcon(Drawable drawableIcon) {
        this.drawableIcon = drawableIcon;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
