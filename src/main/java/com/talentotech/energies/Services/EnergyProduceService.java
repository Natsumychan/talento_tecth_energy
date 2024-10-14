package com.talentotech.energies.Services;

import com.talentotech.energies.DTO.EnergyProduceRequest;
import com.talentotech.energies.Entities.Country;
import com.talentotech.energies.Entities.Energy;
import com.talentotech.energies.Entities.Energy_produced;
import com.talentotech.energies.Repositories.CountryRepository;
import com.talentotech.energies.Repositories.EnergyProduceRepository;
import com.talentotech.energies.Repositories.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EnergyProduceService {

    @Autowired
    private EnergyProduceRepository energyProduceRepository;

    @Autowired
    private EnergyRepository energyRepository;

    @Autowired
    private CountryRepository countryRepository;

    public Energy_produced createEnergyProduced(EnergyProduceRequest energyProduceRequest){
        Energy_produced energyProduced =energyProduceRequest.getEnergyProduced();
        Country country= countryRepository.findById(energyProduceRequest.getCountryId()).orElseThrow(() -> new RuntimeException("Paseador not found"));

        Energy energy= energyRepository.findById(energyProduceRequest.getEnergyId()).orElseThrow(() -> new RuntimeException("Type of energy not found"));

        energyProduced.setEnergy(energy);
        energyProduced.setCountry(country);
        return energyProduceRepository.save(energyProduced);
    }

    //Gel all energy produced
    public List<Energy_produced> getAllEnergyProduced(){
        return energyProduceRepository.findAll();
    }

    // Get energy produced by type of energy
    public List<Energy_produced> getEnergyProducedByEnergyName(String energyName) {
        return energyProduceRepository.findEnergyByName(energyName);
    }

    // Get energy produced by country
    public List<Energy_produced> getEnergyProducedByCountryName(String countryName) {
        return energyProduceRepository.findEnergyByCountryName(countryName);
    }

    // Get energy produced by continent
    public List<Energy_produced> getEnergyProducedByContinentName(String continentName) {
        return energyProduceRepository.findEnergyByContinentName(continentName);
    }

    // Get energy produced by energy AND country
    public List<Energy_produced> getEnergyByTypeAndCountry(String energyName, String countryName) {
        return energyProduceRepository.findByEnergyAndCountry(energyName, countryName);
    }

    //Get energy produced greater than a determined quantity
    public List<Energy_produced> getEnergyProducedGreaterThan(BigDecimal quantity) {
        return energyProduceRepository.findByQuantityProducedGreaterThan(quantity);
    }

    public Energy_produced updateEnergyProduced(int productionId, EnergyProduceRequest energyProduceRequest) {
        // Find register of energy produced by ID
        Energy_produced existingEnergyProduced = energyProduceRepository.findById(productionId)
                .orElseThrow(() -> new RuntimeException("Energy produced not found"));

        // Update attributes using setters from EnergyProduceRequest
        Country country = countryRepository.findById(energyProduceRequest.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        Energy energy = energyRepository.findById(energyProduceRequest.getEnergyId())
                .orElseThrow(() -> new RuntimeException("Energy type not found"));

        // Validate if quantity and date are not null
        if (energyProduceRequest.getEnergyProduced().getQuantity_produced() == null) {
            throw new RuntimeException("Quantity produced cannot be null");
        }

        if (energyProduceRequest.getEnergyProduced().getProduction_date() == null) {
            throw new RuntimeException("Production date cannot be null");
        }

        // Update the information using setters from the entity Energy_produced
        existingEnergyProduced.setCountry(country);
        existingEnergyProduced.setEnergy(energy);
        existingEnergyProduced.setQuantity_produced(energyProduceRequest.getEnergyProduced().getQuantity_produced());
        existingEnergyProduced.setProduction_date(energyProduceRequest.getEnergyProduced().getProduction_date());

        // Save updated Entity
        return energyProduceRepository.save(existingEnergyProduced);
    }

    //Delete an energy produced
    public void deleteEnergyProduced(int id){
        energyProduceRepository.deleteById(id);
    }

}
