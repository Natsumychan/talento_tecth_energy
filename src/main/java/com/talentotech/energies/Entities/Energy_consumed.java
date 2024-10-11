package com.talentotech.energies.Entities;

import java.math.BigDecimal;
import java.time.Year;

public class Energy_consumed {
    private int consume_id;
    private int country_id;
    private int type_energy_id;
    private BigDecimal quantity_consumed;
    private Year consume_date;

    public Energy_consumed(int consume_id, int country_id, int type_energy_id, BigDecimal quantity_cosumed, Year consume_date) {
        this.consume_id = consume_id;
        this.country_id = country_id;
        this.type_energy_id = type_energy_id;
        this.quantity_consumed = quantity_cosumed;
        this.consume_date = consume_date;
    }

    public int getConsume_id() {
        return consume_id;
    }

    public void setConsume_id(int consume_id) {
        this.consume_id = consume_id;
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

    public BigDecimal getQuantity_cosumed() {
        return quantity_consumed;
    }

    public void setQuantity_cosumed(BigDecimal quantity_cosumed) {
        this.quantity_consumed = quantity_cosumed;
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
                ", country_id=" + country_id +
                ", type_energy_id=" + type_energy_id +
                ", quantity_cosumed=" + quantity_consumed +
                ", consume_date=" + consume_date +
                '}';
    }
}
