package com.talentotech.energies.Controllers;

import com.talentotech.energies.Entities.Energy;
import com.talentotech.energies.Services.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/energy")
public class EnergyControllers {
    @Autowired
    private EnergyService energyService;

    //Get all energies
    @GetMapping
    public ResponseEntity<List<Energy>> getAllEnergies(){
        List<Energy> energies = energyService.getAllEnergies();
        return new ResponseEntity<>(energies, HttpStatus.OK);
    }

    //Get energy by ID
    @GetMapping("/{id}")
    public ResponseEntity<Energy> getEnergyById(@PathVariable int id){
        Optional<Energy> energies = energyService.getEnergyById(id);
        return energies.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Energy> updateEnergy(@PathVariable int id, @RequestBody Energy energies) {
        Energy partialUpdateEnergy = new Energy();
        if (energies.getEnergy_name() != null) {
            partialUpdateEnergy.setEnergy_name(energies.getEnergy_name());
        }
        Energy updatedEnergy = energyService.updateEnergyById(id, partialUpdateEnergy);
        return new ResponseEntity<>(updatedEnergy, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnergyById(@PathVariable int id){
        energyService.deleteEnergy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Create energy
    @PostMapping
    public ResponseEntity<Energy> createCountry(@RequestBody Energy energies){
        Energy saveEnergy= energyService.saveEnergy(energies);
        return new ResponseEntity<>(saveEnergy, HttpStatus.CREATED);
    }
}
