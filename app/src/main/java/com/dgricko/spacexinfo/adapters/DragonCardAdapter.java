package com.dgricko.spacexinfo.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.dgricko.spacexinfo.R;
import com.dgricko.spacexinfo.api.model.DragonDTO;

import java.util.List;

public class DragonCardAdapter extends PagerAdapter {

    private List<DragonDTO> dragons;
    private LayoutInflater layoutInflater;
    private Context context;

    public DragonCardAdapter(List<DragonDTO> dragons, Context context) {
        this.dragons = dragons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dragons.size();
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
        TextView card_name, card_wiki, card_feature, card_desc;

        card_img = view.findViewById(R.id.card_image);
        card_name = view.findViewById(R.id.card_name);
        card_wiki = view.findViewById(R.id.card_wiki);
        card_feature = view.findViewById(R.id.card_features);
        card_desc = view.findViewById(R.id.card_desc);

        List<String>imgs = dragons.get(position).getFlickr_images();
        String prev_img = imgs.get(0);

        Glide.with(view.getContext())
                .load(prev_img)
                .placeholder(R.drawable.no_image_available)
                .into(card_img);
        String capacity = "capacity:\t"+dragons.get(position).getCrew_capacity()+"\n";
        String sidewall_angle_deg = "sidewall_angle_deg:\t"+ dragons.get(position).getSidewall_angle_deg()+"\n";
        String orbit_duration_yr = "orbit_duration_yr:\t"+ dragons.get(position).getOrbit_duration_yr()+"\n";
        String dry_mass_kg  = "dry_mass_kg:\t"+dragons.get(position).getDry_mass_kg();

        card_name.setText(dragons.get(position).getName());
        card_wiki.setText(dragons.get(position).getWikipedia());
        card_feature.setText(capacity+sidewall_angle_deg+orbit_duration_yr+dry_mass_kg);
        card_desc.setText(dragons.get(position).getDescription());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
