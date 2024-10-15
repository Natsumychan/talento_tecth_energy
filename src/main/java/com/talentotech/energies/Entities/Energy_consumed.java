package com.talentotech.energies.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Year;

@Entity
public class Energy_consumed {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int consume_id;

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name= "country")
    private Country country;

    @ManyToOne(targetEntity = Energy.class)
    @JoinColumn(name= "Energy type")
    private Energy energy;

    @Column(precision = 30, scale = 5, nullable = false)
    private BigDecimal quantity_consumed;

    @Column(nullable = false, columnDefinition = "YEAR")
    private Year consume_date;

    public Energy_consumed() {
    }

    public Energy_consumed(int consume_id, Country country, Energy energy, BigDecimal quantity_consumed, Year consume_date) {
        this.consume_id = consume_id;
        this.country= country;
        this.energy = energy;
        this.quantity_consumed = quantity_consumed;
        this.consume_date = consume_date;
    }

    public int getConsume_id() {
        return consume_id;
    }

    public void setConsume_id(int consume_id) {
        this.consume_id = consume_id;
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

    public BigDecimal getQuantity_consumed() {
        return quantity_consumed;
    }

    public void setQuantity_consumed(BigDecimal quantity_consumed) {
        this.quantity_consumed = quantity_consumed;
    }

    public Year getConsume_date() {
        return consume_date;
    }

    public void setConsume_date(Year consume_date) {
        this.consume_date = consume_date;
    }

    @Override
    public String toString() {
        return "Energy_consumed{" +
                "consume_id=" + consume_id +
                ", country_id=" + country +
                ", type_energy_id=" + energy +
                ", quantity_cosumed=" + quantity_consumed +
                ", consume_date=" + consume_date +
                '}';
    }
}
