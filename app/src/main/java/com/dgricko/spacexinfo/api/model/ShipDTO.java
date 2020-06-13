package com.dgricko.spacexinfo.api.model;

public class ShipDTO {
    private String id;
    private String legacy_id;
    private String name;
    private String type;
    private String home_port;
    private int year_built;
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegacy_id() {
        return legacy_id;
    }

    public void setLegacy_id(String legacy_id) {
        this.legacy_id = legacy_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHome_port() {
        return home_port;
    }

    public void setHome_port(String home_port) {
        this.home_port = home_port;
    }

    public int getYear_built() {
        return year_built;
    }

    public void setYear_built(int year_built) {
        this.year_built = year_built;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
