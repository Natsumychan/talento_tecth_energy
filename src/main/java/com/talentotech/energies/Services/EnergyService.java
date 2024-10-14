package com.talentotech.energies.Services;

import com.talentotech.energies.Entities.Energy;
import com.talentotech.energies.Repositories.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyService {

    @Autowired
    private EnergyRepository energyRepository;

    //Get all Energies
    public List<Energy> getAllEnergies(){
        return energyRepository.findAll();
    }

    //Get an energy by ID
    public Optional<Energy> getEnergyById(int id){
        return energyRepository.findById(id);
    }

    //Create or update energy
    public Energy updateEnergyById(int id, Energy updatedEnergy) {
        // Check if the energy exists
        return energyRepository.findById(id).map(existingEnergy -> {
            // Update fields
            if (updatedEnergy.getEnergy_name() != null) {
                existingEnergy.setEnergy_name(updatedEnergy.getEnergy_name());
            }
            return energyRepository.save(existingEnergy);
        }).orElseThrow(() -> new RuntimeException("Energy with ID " + id + " not found"));
    }

    //Delete an energy
    public void deleteEnergy(int id){
        energyRepository.deleteById(id);
    }

    //Create an energy
    public Energy saveEnergy(Energy energies){
        return energyRepository.save(energies);
    }
}
