package com.pslyp.reviewapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pslyp.reviewapp.R;
import com.pslyp.reviewapp.adapters.MenuRecyclerAdapter;
import com.pslyp.reviewapp.models.Menu;

import java.util.ArrayList;
import java.util.List;

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

        return view;
    }

    private void initInstance(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_1);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);

        Menu menu;

        List<Menu> mMenuList = new ArrayList<>();
        menu = new Menu("Name 1");
        mMenuList.add(menu);

        menu = new Menu("Name 2");
        mMenuList.add(menu);

        menu = new Menu("Name 3");
        mMenuList.add(menu);

        menu = new Menu("Name 4");
        mMenuList.add(menu);

        menu = new Menu("Name 5");
        mMenuList.add(menu);

        MenuRecyclerAdapter adapter = new MenuRecyclerAdapter(getContext(), mMenuList);
        recyclerView.setAdapter(adapter);
    }

}
