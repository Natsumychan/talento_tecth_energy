package com.talentotech.energies.Entities;

public class User_country {
    private int user_id;
    private int country_id;

    public User_country(int user_id, int country_id) {
        this.user_id = user_id;
        this.country_id = country_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
