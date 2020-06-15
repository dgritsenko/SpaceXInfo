package com.dgricko.spacexinfo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.dgricko.spacexinfo.R;
import com.dgricko.spacexinfo.api.model.RocketDTO;

import java.util.List;

public class RocketCardAdapter extends PagerAdapter {

    private List<RocketDTO> rockets;
    private LayoutInflater layoutInflater;
    private Context context;

    public RocketCardAdapter(List<RocketDTO> rockets, Context context) {
        this.rockets = rockets;
        this.context = context;
    }

    @Override
    public int getCount() {
        return rockets.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_item,container,false);

        ImageView card_img;
        TextView card_name, card_desc;

        card_img = view.findViewById(R.id.card_image);
        card_name = view.findViewById(R.id.card_name);
        card_desc = view.findViewById(R.id.card_desc);

        List<String> imgs = rockets.get(position).getFlickr_images();
        String prev_img = imgs.get(0);

        Glide.with(view.getContext())
                .load(prev_img)
                .into(card_img);

        card_name.setText(rockets.get(position).getName());
        card_desc.setText(rockets.get(position).getDescription());

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
