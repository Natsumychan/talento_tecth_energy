package com.talentotech.energies.Controllers;

import com.talentotech.energies.DTO.EnergyProduceRequest;
import com.talentotech.energies.Entities.Energy_produced;
import com.talentotech.energies.Services.EnergyProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/energyProduced")
public class EnergyProducedControllers {

    @Autowired
    private EnergyProduceService energyProduceService;

    @PostMapping
    public ResponseEntity<Energy_produced> createEnergyProduce(@RequestBody EnergyProduceRequest energyProduceRequest){

        Energy_produced savedEnergyProduced= energyProduceService.createEnergyProduced(energyProduceRequest);
        return new ResponseEntity<>(savedEnergyProduced, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Energy_produced>> getAllEnergiesProduced(){
        List<Energy_produced> energyProducedList= energyProduceService.getAllEnergyProduced();
        return new ResponseEntity<>(energyProducedList, HttpStatus.OK);
    }

    //Get energy produced by ID
    @GetMapping("/{id}")
    public ResponseEntity<Energy_produced> getEnergyProducedById(@PathVariable int id){
        Optional<Energy_produced> energiesProduced = energyProduceService.getEnergyProducedById(id);
        return energiesProduced.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Filter by type of energy
    @GetMapping("/byEnergy")
    public ResponseEntity<List<Energy_produced>> getByEnergy(@RequestParam String energyName) {
        List<Energy_produced> energyProducedList = energyProduceService.getEnergyProducedByEnergyName(energyName);
        return new ResponseEntity<>(energyProducedList,  HttpStatus.OK);
    }

    // Filter by country
    @GetMapping("/byCountry")
    public ResponseEntity<List<Energy_produced>> getByCountry(@RequestParam String countryName) {
        List<Energy_produced> energyProducedList = energyProduceService.getEnergyProducedByCountryName(countryName);
        return new ResponseEntity<>(energyProducedList,  HttpStatus.OK);
    }

    // Filter by continent
    @GetMapping("/byContinent")
    public ResponseEntity<List<Energy_produced>> getByContinent(@RequestParam String continentName) {
        List<Energy_produced> energyProducedList = energyProduceService.getEnergyProducedByContinentName(continentName);
        return new ResponseEntity<>(energyProducedList,  HttpStatus.OK);
    }

    // Filter by energy type AND country
    @GetMapping("/byEnergyAndCountry")
    public ResponseEntity<List<Energy_produced>> getByEnergyAndCountry(@RequestParam String energyName, @RequestParam String countryName) {
        List<Energy_produced> energyProducedList = energyProduceService.getEnergyByTypeAndCountry(energyName, countryName);
        return new ResponseEntity<>(energyProducedList,  HttpStatus.OK);
    }

    // Filter by a greater quantity determined
    @GetMapping("/byQuantity")
    public ResponseEntity<List<Energy_produced>> getByQuantity(@RequestParam BigDecimal quantity) {
        List<Energy_produced> energyProducedList = energyProduceService.getEnergyProducedGreaterThan(quantity);
        return new ResponseEntity<>(energyProducedList,  HttpStatus.OK);
    }

    @GetMapping("/totalSummary")
    public List<Object[]> getAggregatedEnergyData() {
        return energyProduceService.getTotalEnergyProducedByCountryAndYear();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Energy_produced> updateEnergyProduced(@PathVariable("id") int productionId, @RequestBody EnergyProduceRequest energyProducedRequest) {
        Energy_produced updatedEnergyProduced = energyProduceService.updateEnergyProduced(productionId, energyProducedRequest);
        return new ResponseEntity<>(updatedEnergyProduced, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnergyProducedById(@PathVariable int id){
        energyProduceService.deleteEnergyProduced(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
