package com.ollie.androidrestaurant;

public class Restaurant {
    /**
     * All data
     */
    private String name;
    private String address;
    private String type;
    private double lat;
    private double lng;
    /**
     * Constructor
     */
    public Restaurant(String name, String address, String type, double lat, double lng) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.lng = lng;
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public double getLat() { return lat; }

    public double getLng() { return lng; }

}