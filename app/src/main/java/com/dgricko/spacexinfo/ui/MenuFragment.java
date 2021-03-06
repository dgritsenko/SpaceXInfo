package com.dgricko.spacexinfo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgricko.spacexinfo.adapters.ProjectListAdapter;
import com.dgricko.spacexinfo.R;
import com.dgricko.spacexinfo.SpaceProject;


public class MenuFragment extends Fragment implements ProjectListAdapter.onItemListClick {

    private SpaceProject[] projects;
    private RecyclerView projectsList;
    private  ProjectListAdapter projectListAdapter;

    private NavController navController;


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

        navController = Navigation.findNavController(view);

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
        if (spaceProject.getName().contains("Rockets")){
            navController.navigate(R.id.action_menuFragment_to_rocketFragment);
        }else if (spaceProject.getName().contains("Dragons")){
            navController.navigate(R.id.action_menuFragment_to_dragonFragment);
        }else if (spaceProject.getName().contains("Ships")){
            navController.navigate(R.id.action_menuFragment_to_shipFragment);
        }else {
            navController.navigate(R.id.action_menuFragment_to_crewFragment);
        }
    }
}