package com.talentotech.energies.Repositories;

import com.talentotech.energies.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer > {
}
