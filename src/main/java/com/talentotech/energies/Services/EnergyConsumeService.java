package com.talentotech.energies.Services;

import com.talentotech.energies.DTO.EnergyConsumeRequest;
import com.talentotech.energies.Entities.Country;
import com.talentotech.energies.Entities.Energy;
import com.talentotech.energies.Entities.Energy_consumed;
import com.talentotech.energies.Repositories.CountryRepository;
import com.talentotech.energies.Repositories.EnergyConsumeRepository;
import com.talentotech.energies.Repositories.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EnergyConsumeService {

    @Autowired
    private EnergyConsumeRepository energyConsumeRepository;

    @Autowired
    private EnergyRepository energyRepository;

    @Autowired
    private CountryRepository countryRepository;

    public Energy_consumed createEnergyConsumed(EnergyConsumeRequest energyConsumeRequest){
        Energy_consumed energyConsumed =energyConsumeRequest.getEnergyConsumed();
        Country country= countryRepository.findById(energyConsumeRequest.getCountryId()).orElseThrow(() -> new RuntimeException("Country not found"));

        Energy energy= energyRepository.findById(energyConsumeRequest.getEnergyId()).orElseThrow(() -> new RuntimeException("Type of energy not found"));

        energyConsumed.setEnergy(energy);
        energyConsumed.setCountry(country);
        return energyConsumeRepository.save(energyConsumed);
    }

    //Gel all energy consumed
    public List<Energy_consumed> getAllEnergyConsumed(){
        return energyConsumeRepository.findAll();
    }

    //Get an energy consumed by ID
    public Optional<Energy_consumed> getEnergyConsumedById(int id){
        return energyConsumeRepository.findById(id);
    }

    // Get energy consumed by type of energy
    public List<Energy_consumed> getEnergyConsumedByEnergyName(String energyName) {
        return energyConsumeRepository.findEnergyByName(energyName);
    }

    // Get energy consumed by country
    public List<Energy_consumed> getEnergyConsumedByCountryName(String countryName) {
        return energyConsumeRepository.findEnergyByCountryName(countryName);
    }

    // Get energy consumed by continent
    public List<Energy_consumed> getEnergyConsumedByContinentName(String continentName) {
        return energyConsumeRepository.findEnergyByContinentName(continentName);
    }

    // Get energy consumed by energy AND country
    public List<Energy_consumed> getEnergyByTypeAndCountry(String energyName, String countryName) {
        return energyConsumeRepository.findByEnergyAndCountry(energyName, countryName);
    }

    //Get energy consumed greater than a determined quantity
    public List<Energy_consumed> getEnergyConsumedGreaterThan(BigDecimal quantity) {
        return energyConsumeRepository.findByQuantityConsumedGreaterThan(quantity);
    }

    public Energy_consumed updateEnergyConsumed(int consumeId, EnergyConsumeRequest energyConsumeRequest) {
        // Find register of energy consumed by ID
        Energy_consumed existingEnergyConsumed = energyConsumeRepository.findById(consumeId)
                .orElseThrow(() -> new RuntimeException("Energy consumed not found"));

        // Update attributes using setters from EnergyConsumeRequest
        Country country = countryRepository.findById(energyConsumeRequest.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        Energy energy = energyRepository.findById(energyConsumeRequest.getEnergyId())
                .orElseThrow(() -> new RuntimeException("Energy type not found"));

        // Validate if quantity and date are not null
        if (energyConsumeRequest.getEnergyConsumed().getQuantity_consumed() == null) {
            throw new RuntimeException("Quantity produced cannot be null");
        }

        if (energyConsumeRequest.getEnergyConsumed().getConsume_date() == null) {
            throw new RuntimeException("Production date cannot be null");
        }

        // Update the information using setters from the entity Energy_consumed
        existingEnergyConsumed.setCountry(country);
        existingEnergyConsumed.setEnergy(energy);
        existingEnergyConsumed.setQuantity_consumed(energyConsumeRequest.getEnergyConsumed().getQuantity_consumed());
        existingEnergyConsumed.setConsume_date(energyConsumeRequest.getEnergyConsumed().getConsume_date());

        // Save updated Entity
        return energyConsumeRepository.save(existingEnergyConsumed);
    }

    //Delete an energy consumed
    public void deleteEnergyConsumed(int id){
        energyConsumeRepository.deleteById(id);
    }



}
