package com.talentotech.energies.Entities;

import jakarta.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  int country_id;

    @Column(nullable = false)
    private  String country_name;

    @Column(nullable = false)
    private  String continent_name;

    public Country() {
    }

    public Country(int country_id, String country_name, String continent_name) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.continent_name = continent_name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getContinent_name() {
        return continent_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }
}
