package com.dgricko.spacexinfo.api.model;

import java.util.List;

public class RocketDTO {
    private String id;
    private String name;
    private String description;
    private String wikipedia;
    private String company;
    private String country;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getFlickr_images() {
        return flickr_images;
    }

    public void setFlickr_images(List<String> flickr_images) {
        this.flickr_images = flickr_images;
    }

    @Override
    public String toString() {
        return "RocketDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", wikipedia='" + wikipedia + '\'' +
                ", company='" + company + '\'' +
                ", country='" + country + '\'' +
                ", flickr_images=" + flickr_images + "\n"+
                '}';
    }
}
