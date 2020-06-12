package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class

SpringSecurityJdbcDataSource {
    @Bean
    public CommandLineRunner run(UserRepository userRepository, RoleRepository rolesRepository) throws Exception{
        return (String[]args)->{
            User user = new User("user", "employee@domain", "user", "Employee", "Dude", "555-555-5555", true);
            Role userRole = new Role("user", "ROLE_USER");

            userRepository.save(user);
            rolesRepository.save(userRole);

            User admin = new User("admin", "bossman@domain", "admin", "Boss", "Man", "555-555-5555", true);
            Role adminRole = new Role("admin", "ROLE_ADMIN");

            userRepository.save(admin);
            rolesRepository.save(adminRole);
//

        };
    }

}
