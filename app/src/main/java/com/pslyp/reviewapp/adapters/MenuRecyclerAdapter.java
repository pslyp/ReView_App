package com.pslyp.reviewapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pslyp.reviewapp.R;
import com.pslyp.reviewapp.models.Menu;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<Menu> mMenuLIst;

    private final String BASE_IMAGE_URL = "http://pilot.cp.su.ac.th/usr/u07580536/yhinyhang/images/menu/";

    public MenuRecyclerAdapter(Context context, List<Menu> menuList) {
        this.mContext = context;
        this.mMenuLIst = menuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.menu_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Menu menu = mMenuLIst.get(position);

        Picasso.get().load(BASE_IMAGE_URL.concat(menu.getImage())).into(holder.image);

        holder.nameText.setText(menu.getName());

        holder.favoriteToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    holder.favoriteToggle.setBackgroundResource(R.drawable.ic_favorite_white_24dp);
                } else {
                    holder.favoriteToggle.setBackgroundResource(R.drawable.ic_favorite_border_white_24dp);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMenuLIst.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView nameText;
        public ToggleButton favoriteToggle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.background_image_view);
            nameText = itemView.findViewById(R.id.name_text_view);
            favoriteToggle = itemView.findViewById(R.id.favorite_toggle);
        }
    }
}
