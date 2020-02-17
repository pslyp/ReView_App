package com.pslyp.reviewapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuRes extends DefaultRes {

    @SerializedName("data")
    @Expose
    private List<Menu> mMenuList;

    public MenuRes(boolean status, String messages, List<Menu> menuList) {
        super(status, messages);
        this.mMenuList = menuList;
    }

    public List<Menu> getMenuList() {
        return mMenuList;
    }

}
