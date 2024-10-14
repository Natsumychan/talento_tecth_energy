package com.talentotech.energies.DTO;

import com.talentotech.energies.Entities.Energy_produced;

public class EnergyProduceRequest {
    private int countryId;
    private int energyId;
    private Energy_produced energyProduced;

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

    public Energy_produced getEnergyProduced() {
        return energyProduced;
    }

    public void setEnergyProduced(Energy_produced energyProduced) {
        this.energyProduced = energyProduced;
    }
}
