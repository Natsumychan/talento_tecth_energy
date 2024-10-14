package com.talentotech.energies.Services;

import com.talentotech.energies.Entities.Country;
import com.talentotech.energies.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Get all countries
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    //Get a country by ID
    public Optional<Country> getCountryById(int id){
        return countryRepository.findById(id);
    }

    //Create or update country
    public Country updateCountryById(int id, Country updatedCountry) {
        // Check if the country exists
        return countryRepository.findById(id).map(existingCountry -> {
            // Update fields
            if (updatedCountry.getCountry_name() != null) {
                existingCountry.setCountry_name(updatedCountry.getCountry_name());
            }
            if (updatedCountry.getContinent_name() != null) {
                existingCountry.setContinent_name(updatedCountry.getContinent_name());
            }
            return countryRepository.save(existingCountry);
        }).orElseThrow(() -> new RuntimeException("Country with ID " + id + " not found"));
    }

    //Delete a country
    public void deleteCountry(int id){
        countryRepository.deleteById(id);
    }

    //Create a country
    public Country saveCountry(Country countries){
        return countryRepository.save(countries);
    }

}
