package com.talentotech.energies.DTO;

import com.talentotech.energies.Entities.Energy_consumed;

public class EnergyConsumeRequest {
    private int countryId;
    private int energyId;
    private Energy_consumed energyConsumed;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getEnergyId() {
        return energyId;
    }

    public void setEnergyId(int energyId) {
        this.energyId = energyId;
    }

    public Energy_consumed getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(Energy_consumed energyConsumed) {
        this.energyConsumed = energyConsumed;
    }
}
