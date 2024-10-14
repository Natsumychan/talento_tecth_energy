package com.talentotech.energies.Repositories;

import com.talentotech.energies.Entities.Country;
import com.talentotech.energies.Entities.Energy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyRepository extends JpaRepository<Energy, Integer > {
}
