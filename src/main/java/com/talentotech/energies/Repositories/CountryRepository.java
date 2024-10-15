package com.talentotech.energies.Repositories;

import com.talentotech.energies.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer > {
}
