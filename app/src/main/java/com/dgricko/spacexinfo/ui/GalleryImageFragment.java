package com.dgricko.spacexinfo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgricko.spacexinfo.adapters.GalleryAdapter;
import com.dgricko.spacexinfo.MainActivity;
import com.dgricko.spacexinfo.PhotoActivity;
import com.dgricko.spacexinfo.R;

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


        final List<String> imagesForGallery = ((MainActivity)getActivity()).getImagesForGallery();



        images = (ArrayList<String>) imagesForGallery;

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getContext(),2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new GalleryAdapter(images,getContext());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getContext(), recyclerView, new GalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                PhotoActivity.start(view.getContext(),imagesForGallery.get(position));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }
}