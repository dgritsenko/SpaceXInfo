package com.dgricko.spacexinfo.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.dgricko.spacexinfo.R;
import com.dgricko.spacexinfo.api.model.ShipDTO;

import java.util.List;

public class ShipCardAdapter extends PagerAdapter {
    private List<ShipDTO> ships;
    private LayoutInflater layoutInflater;
    private Context context;

    public ShipCardAdapter(List<ShipDTO> ships, Context context) {
        this.ships = ships;
        this.context = context;
    }

    @Override
    public int getCount() {
        return ships.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_item,container,false);

        ImageView card_img;
        TextView card_name, card_feature, card_desc;

        card_img = view.findViewById(R.id.card_image);
        card_name = view.findViewById(R.id.card_name);
        card_feature = view.findViewById(R.id.card_features);
        card_desc = view.findViewById(R.id.card_desc);

        String prev_img = ships.get(position).getImage();


        Glide.with(view.getContext())
                .load(prev_img)
                .placeholder(R.drawable.no_image_available)
                .into(card_img);

        String home_port ="home_port:\t"+ ships.get(position).getHome_port()+"\n";
        String year_built = "year_built:\t"+ships.get(position).getYear_built();

        card_name.setText(ships.get(position).getName());
        card_feature.setText(home_port+year_built);
        card_desc.setText(ships.get(position).getType());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
