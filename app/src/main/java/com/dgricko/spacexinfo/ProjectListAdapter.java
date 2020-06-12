package com.dgricko.spacexinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectViewHolder> {
    private SpaceProject[] projects;

    private onItemListClick onItemListClick;

    public ProjectListAdapter(SpaceProject[] projects, ProjectListAdapter.onItemListClick onItemListClick) {
        this.projects = projects;
        this.onItemListClick = onItemListClick;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item,parent,false);

        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
            holder.list_nameProject.setText(projects[position].getName());
            holder.list_descProject.setText(projects[position].getDescription());
            holder.list_imgProject.setImageResource(projects[position].getImgResource());
    }

    @Override
    public int getItemCount() {
        return projects.length;
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView list_imgProject;
        private TextView list_nameProject;
        private TextView list_descProject;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            list_imgProject = itemView.findViewById(R.id.list_image);
            list_nameProject = itemView.findViewById(R.id.list_title);
            list_descProject = itemView.findViewById(R.id.list_description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListClick.onClickListener(projects[getAdapterPosition()],getAdapterPosition());
        }


    }
    public interface onItemListClick    {
        void onClickListener(SpaceProject spaceProject, int position);
    }
}
