package com.talentotech.energies.Controllers;

import com.talentotech.energies.Entities.Country;
import com.talentotech.energies.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "http://localhost:4200/" )
@RestController
@RequestMapping("/country")
public class CountryControllers {

    @Autowired
    private CountryService countryService;

    //Get all
    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries(){
        List<Country> countries = countryService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    //Get country by ID
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable int id){
        Optional <Country> countries = countryService.getCountryById(id);
        return countries.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable int id, @RequestBody Country country) {
        Country partialUpdateCountry = new Country();
        if (country.getCountry_name() != null) {
            partialUpdateCountry.setCountry_name(country.getCountry_name());
        }
        if (country.getContinent_name() != null) {
            partialUpdateCountry.setContinent_name(country.getContinent_name());
        }
        Country updatedCountry = countryService.updateCountryById(id, partialUpdateCountry);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable int id){
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Create country
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country countries){
        Country saveCountry= countryService.saveCountry(countries);
        return new ResponseEntity<>(saveCountry, HttpStatus.CREATED);
    }


}
