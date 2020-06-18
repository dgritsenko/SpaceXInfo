package com.dgricko.spacexinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class GalleryImageFragment extends Fragment {

    private ArrayList<String> images = new ArrayList<>();
    private RecyclerView recyclerView;
    private GalleryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public GalleryImageFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> strImg = new ArrayList<>();
        strImg.add("https://farm9.staticflickr.com/8618/16649075267_d18cbb4342_b.jpg");
        strImg.add("https://farm9.staticflickr.com/8618/16649075267_d18cbb4342_b.jpg");
        strImg.add("https://farm9.staticflickr.com/8618/16649075267_d18cbb4342_b.jpg");
        strImg.add("https://farm9.staticflickr.com/8618/16649075267_d18cbb4342_b.jpg");

        images = strImg;

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getContext(),2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new GalleryAdapter(images,getContext());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getContext(), recyclerView, new GalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                System.out.println("!CLICK img!!");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        List<String> imgs = ((MainActivity)getActivity()).getImagesForGallery();
        System.out.println("!IMGD"+imgs);
    }
}