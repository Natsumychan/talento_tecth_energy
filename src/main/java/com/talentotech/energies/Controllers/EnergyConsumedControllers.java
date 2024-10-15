package com.talentotech.energies.Controllers;

import com.talentotech.energies.DTO.EnergyConsumeRequest;
import com.talentotech.energies.Entities.Energy;
import com.talentotech.energies.Entities.Energy_consumed;
import com.talentotech.energies.Services.EnergyConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/energyConsumed")
public class EnergyConsumedControllers {

    @Autowired
    private EnergyConsumeService energyConsumeService;

    @PostMapping
    public ResponseEntity<Energy_consumed> createEnergyConsume(@RequestBody EnergyConsumeRequest energyConsumeRequest){
        Energy_consumed savedEnergyConsumed= energyConsumeService.createEnergyConsumed(energyConsumeRequest);
        return new ResponseEntity<>(savedEnergyConsumed, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Energy_consumed>> getAllEnergiesProduced(){
        List<Energy_consumed> energyConsumedList= energyConsumeService.getAllEnergyConsumed();
        return new ResponseEntity<>(energyConsumedList, HttpStatus.OK);
    }

    //Get energy consumed by ID
    @GetMapping("/{id}")
    public ResponseEntity<Energy_consumed> getEnergyConsumedById(@PathVariable int id){
        Optional<Energy_consumed> energiesConsumed = energyConsumeService.getEnergyConsumedById(id);
        return energiesConsumed.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Filter by type of energy
    @GetMapping("/byEnergy")
    public ResponseEntity<List<Energy_consumed>> getByEnergy(@RequestParam String energyName) {
        List<Energy_consumed> energyConsumedList = energyConsumeService.getEnergyConsumedByEnergyName(energyName);
        return new ResponseEntity<>(energyConsumedList,  HttpStatus.OK);
    }

    // Filter by country
    @GetMapping("/byCountry")
    public ResponseEntity<List<Energy_consumed>> getByCountry(@RequestParam String countryName) {
        List<Energy_consumed> energyConsumedList = energyConsumeService.getEnergyConsumedByCountryName(countryName);
        return new ResponseEntity<>(energyConsumedList,  HttpStatus.OK);
    }

    // Filter by continent
    @GetMapping("/byContinent")
    public ResponseEntity<List<Energy_consumed>> getByContinent(@RequestParam String continentName) {
        List<Energy_consumed> energyConsumedList = energyConsumeService.getEnergyConsumedByContinentName(continentName);
        return new ResponseEntity<>(energyConsumedList,  HttpStatus.OK);
    }

    // Filter by energy type AND country
    @GetMapping("/byEnergyAndCountry")
    public ResponseEntity<List<Energy_consumed>> getByEnergyAndCountry(@RequestParam String energyName, @RequestParam String countryName) {
        List<Energy_consumed> energyConsumedList = energyConsumeService.getEnergyByTypeAndCountry(energyName, countryName);
        return new ResponseEntity<>(energyConsumedList,  HttpStatus.OK);
    }

    // Filter by a greater quantity determined
    @GetMapping("/byQuantity")
    public ResponseEntity<List<Energy_consumed>> getByQuantity(@RequestParam BigDecimal quantity) {
        List<Energy_consumed> energyConsumedList = energyConsumeService.getEnergyConsumedGreaterThan(quantity);
        return new ResponseEntity<>(energyConsumedList,  HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Energy_consumed> updateEnergyConsumed(@PathVariable("id") int productionId, @RequestBody EnergyConsumeRequest energyConsumeRequest) {
        Energy_consumed updatedEnergyConsumed = energyConsumeService.updateEnergyConsumed(productionId, energyConsumeRequest);
        return new ResponseEntity<>(updatedEnergyConsumed, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnergyConsumedById(@PathVariable int id){
        energyConsumeService.deleteEnergyConsumed(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
