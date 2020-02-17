package com.pslyp.reviewapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pslyp.reviewapp.R;
import com.pslyp.reviewapp.adapters.MenuRecyclerAdapter;
import com.pslyp.reviewapp.api.RetrofitClient;
import com.pslyp.reviewapp.models.Menu;
import com.pslyp.reviewapp.models.MenuRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initInstance(view);
        initListMenu();

        return view;
    }

    private void initInstance(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_1);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initListMenu() {
        Call<MenuRes> call = RetrofitClient.getInstance().Req().getMenu();
        call.enqueue(new Callback<MenuRes>() {
            @Override
            public void onResponse(Call<MenuRes> call, Response<MenuRes> response) {
                MenuRes res = response.body();
                List<Menu> menuList = res.getMenuList();

                if(res.isStatus()) {
                    if(menuList.size() != 0) {
                        MenuRecyclerAdapter adapter = new MenuRecyclerAdapter(getContext(), menuList);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<MenuRes> call, Throwable t) {
                Log.e("Get Menu", t.getMessage());
            }
        });
    }

}
