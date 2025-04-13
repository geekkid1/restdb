package org.example.restdb;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<UserData, Long> {
    Optional<UserData> findByName(String name);
}
