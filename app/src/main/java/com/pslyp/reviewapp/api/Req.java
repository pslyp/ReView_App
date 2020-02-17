package com.pslyp.reviewapp.api;

import com.pslyp.reviewapp.models.MenuRes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Req {

    @GET("getmenu.php")
    Call<MenuRes> getMenu();

}
