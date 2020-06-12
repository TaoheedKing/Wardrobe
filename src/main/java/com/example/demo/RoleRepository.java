package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Set<Role> findAllByUsername(String username);

}
