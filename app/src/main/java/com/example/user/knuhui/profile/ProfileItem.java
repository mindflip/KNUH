package com.example.user.knuhui.profile;

import android.graphics.drawable.Drawable;

public class ProfileItem {
    private Drawable drawableIcon;
    private String menu;
    private Drawable drawable;

    public Drawable getDrawableIcon() {
        return drawableIcon;
    }

    public void setDrawableIcon(Drawable drawableIcon) {
        this.drawableIcon = drawableIcon;
    }

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
