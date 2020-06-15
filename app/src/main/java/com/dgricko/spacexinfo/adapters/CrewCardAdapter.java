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
import com.dgricko.spacexinfo.api.model.CrewDTO;

import java.util.List;

public class CrewCardAdapter extends PagerAdapter {
    private List<CrewDTO> crews;
    private LayoutInflater layoutInflater;
    private Context context;

    public CrewCardAdapter(List<CrewDTO> crews, Context context) {
        this.crews = crews;
        this.context = context;
    }

    @Override
    public int getCount() {
        return crews.size();
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
        TextView card_name, card_wiki, card_desc;

        card_img = view.findViewById(R.id.card_image);
        card_name = view.findViewById(R.id.card_name);
        card_wiki = view.findViewById(R.id.card_wiki);
        card_desc = view.findViewById(R.id.card_desc);


        String prev_img = crews.get(position).getImage();

        Glide.with(view.getContext())
                .load(prev_img)
                .fitCenter()
                .into(card_img);

        card_name.setText(crews.get(position).getName());
        card_wiki.setText(crews.get(position).getWikipedia());
        card_desc.setText(crews.get(position).getAgency());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
