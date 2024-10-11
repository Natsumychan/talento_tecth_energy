package com.talentotech.energies.Repositories;

import com.talentotech.energies.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
