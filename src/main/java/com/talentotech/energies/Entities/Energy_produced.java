package com.talentotech.energies.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Year;

@Entity
public class Energy_produced {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int production_id;

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name= "country")
    private Country country;

    @ManyToOne(targetEntity = Energy.class)
    @JoinColumn(name= "Energy type")
    private Energy energy;

    @Column(precision = 30, scale = 5, nullable = false)
    private BigDecimal quantity_produced;

    @Column(nullable = false, columnDefinition = "YEAR")
    private Year production_date;

    public Energy_produced() {
    }

    public Energy_produced(int production_id, Country country, Energy energy, BigDecimal quantity_produced, Year production_date) {
        this.production_id = production_id;
        this.country = country;
        this.energy = energy;
        this.quantity_produced = quantity_produced;
        this.production_date = production_date;
    }

    public int getProduction_id() {
        return production_id;
    }

    public void setProduction_id(int production_id) {
        this.production_id = production_id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Energy getEnergy() {
        return energy;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
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
