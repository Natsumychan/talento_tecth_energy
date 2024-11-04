package com.talentotech.energies.Repositories;

import com.talentotech.energies.Entities.Energy_produced;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EnergyProduceRepository extends JpaRepository<Energy_produced, Integer> {
    // filter by type of energy
    @Query("SELECT e FROM Energy_produced e WHERE e.energy.energy_name = :energyName")
    List<Energy_produced> findEnergyByName(@Param("energyName") String energyName);

    // filter by country
    @Query("SELECT e FROM Energy_produced e WHERE e.country.country_name = :countryName")
    List<Energy_produced> findEnergyByCountryName(@Param("countryName") String countryName);

    // filter by continent
    @Query("SELECT e FROM Energy_produced e WHERE e.country.continent_name = :continentName")
    List<Energy_produced> findEnergyByContinentName(@Param("continentName") String continentName);

    // filter by energy and country
    @Query("SELECT e FROM Energy_produced e WHERE e.energy.energy_name = :energyName AND e.country.country_name = :countryName")
    List<Energy_produced> findByEnergyAndCountry(@Param("energyName") String energyName, @Param("countryName") String countryName);

    // filter by Greater quantity produced
    @Query("SELECT e FROM Energy_produced e WHERE e.quantity_produced > :quantity")
    List<Energy_produced> findByQuantityProducedGreaterThan(@Param("quantity") BigDecimal quantity);

    @Query("SELECT ep.production_date, ep.country.country_name, SUM(ep.quantity_produced) " +
            "FROM Energy_produced ep " +
            "GROUP BY ep.production_date, ep.country.country_name " +
            "ORDER BY ep.production_date ASC, ep.country.country_name ASC")
    List<Object[]> sumEnergyProducedByCountryAndDate();

}
