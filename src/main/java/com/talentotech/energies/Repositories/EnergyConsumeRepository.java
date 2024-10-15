package com.talentotech.energies.Repositories;

import com.talentotech.energies.Entities.Energy_consumed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EnergyConsumeRepository extends JpaRepository<Energy_consumed, Integer> {
    // filter by type of energy
    @Query("SELECT e FROM Energy_consumed e WHERE e.energy.energy_name = :energyName")
    List<Energy_consumed> findEnergyByName(@Param("energyName") String energyName);

    // filter by country
    @Query("SELECT e FROM Energy_consumed e WHERE e.country.country_name = :countryName")
    List<Energy_consumed> findEnergyByCountryName(@Param("countryName") String countryName);

    // filter by continent
    @Query("SELECT e FROM Energy_consumed e WHERE e.country.continent_name = :continentName")
    List<Energy_consumed> findEnergyByContinentName(@Param("continentName") String continentName);

    // filter by energy and country
    @Query("SELECT e FROM Energy_consumed e WHERE e.energy.energy_name = :energyName AND e.country.country_name = :countryName")
    List<Energy_consumed> findByEnergyAndCountry(@Param("energyName") String energyName, @Param("countryName") String countryName);

    // filter by Greater quantity consumed
    @Query("SELECT e FROM Energy_consumed e WHERE e.quantity_consumed > :quantity")
    List<Energy_consumed> findByQuantityConsumedGreaterThan(@Param("quantity") BigDecimal quantity);

}
