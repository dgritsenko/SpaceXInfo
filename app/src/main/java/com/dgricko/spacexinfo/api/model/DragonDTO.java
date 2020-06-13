package com.dgricko.spacexinfo.api.model;

import java.util.List;

public class DragonDTO {
    private String id;
    private String name;
    private String type;
    private int crew_capacity;
    private int sidewall_angle_deg;
    private int orbit_duration_yr;
    private int dry_mass_kg;
    private String wikipedia;
    private String description;
    private List<String> flickr_images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getCrew_capacity() {
        return crew_capacity;
    }

    public void setCrew_capacity(int crew_capacity) {
        this.crew_capacity = crew_capacity;
    }

    public int getSidewall_angle_deg() {
        return sidewall_angle_deg;
    }

    public void setSidewall_angle_deg(int sidewall_angle_deg) {
        this.sidewall_angle_deg = sidewall_angle_deg;
    }

    public int getOrbit_duration_yr() {
        return orbit_duration_yr;
    }

    public void setOrbit_duration_yr(int orbit_duration_yr) {
        this.orbit_duration_yr = orbit_duration_yr;
    }

    public int getDry_mass_kg() {
        return dry_mass_kg;
    }

    public void setDry_mass_kg(int dry_mass_kg) {
        this.dry_mass_kg = dry_mass_kg;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getFlickr_images() {
        return flickr_images;
    }

    public void setFlickr_images(List<String> flickr_images) {
        this.flickr_images = flickr_images;
    }
}
