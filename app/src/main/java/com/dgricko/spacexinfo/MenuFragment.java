package com.dgricko.spacexinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MenuFragment extends Fragment implements ProjectListAdapter.onItemListClick{

    private SpaceProject[] projects;
    private RecyclerView projectsList;
    private  ProjectListAdapter projectListAdapter;


    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        projectsList = view.findViewById(R.id.project_list_view);
        projects = SpaceProject.projects;

        projectListAdapter = new ProjectListAdapter(projects,this);

        projectsList.setHasFixedSize(true);
        projectsList.setLayoutManager(new LinearLayoutManager(getContext()));
        projectsList.setAdapter(projectListAdapter);
    }

    @Override
    public void onClickListener(SpaceProject spaceProject, int position) {
        Log.d("MENU_LOG","Project " + spaceProject.getName());
    }
}