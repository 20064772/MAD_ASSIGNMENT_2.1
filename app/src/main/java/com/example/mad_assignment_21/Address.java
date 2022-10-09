package com.example.mad_assignment_21;

public class Address {

    private String street;
    private String suite;
    private String city;
    public String zipcode;
    private Geo geo;


    public Address(String street, String suite, String city, String zipcode, String lat, String longi) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = new Geo(lat, longi);
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getLat() {
        return geo.getLat();
    }

    public String getLongi(){
        return geo.getLongi();
    }
}

