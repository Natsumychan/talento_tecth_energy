package com.talentotech.energies.Entities;

import java.time.Year;

public class Energy_report {

    private Country country;
    private Energy energy;
    private Energy_produced energyProduced;
    private Energy_consumed energyConsumed;
    private Year reportYear;

    // Constructor
    public Energy_report(Country country, Energy energy, Energy_produced energyProduced, Energy_consumed energyConsumed, Year reportYear) {
        this.country = country;
        this.energy = energy;
        this.energyProduced = energyProduced;
        this.energyConsumed = energyConsumed;
        this.reportYear = reportYear;
    }

    // Getters and Setters
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

    public Energy_produced getEnergyProduced() {
        return energyProduced;
    }

    public void setEnergyProduced(Energy_produced energyProduced) {
        this.energyProduced = energyProduced;
    }

    public Energy_consumed getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(Energy_consumed energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    public Year getReportYear() {
        return reportYear;
    }

    public void setReportYear(Year reportYear) {
        this.reportYear = reportYear;
    }

    @Override
    public String toString() {
        return "EnergyReport{" +
                "country=" + country +
                ", energy=" + energy +
                ", energyProduced=" + energyProduced +
                ", energyConsumed=" + energyConsumed +
                ", reportYear=" + reportYear +
                '}';
    }
}


