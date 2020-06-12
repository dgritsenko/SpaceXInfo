package com.dgricko.spacexinfo;

public class SpaceProject {

    private String name;
    private String description;
    private int imgResource;


    public static final SpaceProject[] projects={
      new SpaceProject("Rockets","Detailed info about rocket versions",R.drawable.ic_rocket_list),
      new SpaceProject("Crew","Detailed info on dragon crew members",R.drawable.ic_cosmonaut),
      new SpaceProject("Dragons","Detailed info about dragon capsule versions",R.drawable.ic_dragon),
      new SpaceProject("Ships","Detailed info about ships in the SpaceX fleet",R.drawable.ic_ship)
    };

    public SpaceProject(String name, String description, int imgResource) {
        this.name = name;
        this.description = description;
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
