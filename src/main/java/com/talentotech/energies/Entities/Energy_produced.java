package com.talentotech.energies.Entities;

import java.math.BigDecimal;
import java.time.Year;

public class Energy_produced {
    private int production_id;
    private int country_id;
    private int type_energy_id;
    private BigDecimal quantity_produced;
    private Year production_date;

    public Energy_produced(int production_id, int country_id, int type_energy_id, BigDecimal quantity_produced, Year production_date) {
        this.production_id = production_id;
        this.country_id = country_id;
        this.type_energy_id = type_energy_id;
        this.quantity_produced = quantity_produced;
        this.production_date = production_date;
    }

    public int getProduction_id() {
        return production_id;
    }

    public void setProduction_id(int production_id) {
        this.production_id = production_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getType_energy_id() {
        return type_energy_id;
    }

    public void setType_energy_id(int type_energy_id) {
        this.type_energy_id = type_energy_id;
    }

    public BigDecimal getQuantity_produced() {
        return quantity_produced;
    }

    public void setQuantity_produced(BigDecimal quantity_produced) {
        this.quantity_produced = quantity_produced;
    }

    public Year getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Year production_date) {
        this.production_date = production_date;
    }
}
