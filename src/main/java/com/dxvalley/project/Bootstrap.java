package com.dxvalley.project;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.dxvalley.project.models.Address;
import com.dxvalley.project.models.Role;
import com.dxvalley.project.models.Users;
import com.dxvalley.project.repositories.AddressRepository;
import com.dxvalley.project.repositories.RoleRepository;
import com.dxvalley.project.repositories.UserRepository;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "database", name = "seed", havingValue = "true")
public class Bootstrap {

    Role admin = new Role("admin", "Bank users");
    Role superAdmin = new Role("superAdmin", "Admin with all power");
    Role primaryCooperativeUser = new Role("primaryCooperativeUser", "A single primary cooperative user");
    Role unionUser = new Role("unionUser", "A single union user");
    Address address1= new Address("939338005","mahletdemeke0791@gmail.com","Ethiopia","Bole","bole","10","bole","01");
    Address address2= new Address("924385314","elshadayt@coopbankoromria.com.et","Ethiopia","Bole","bole","10","bole","01");
    Users user1 = new Users("924385314", "elshu13", "Elshaday Tamire", "elshadayt@coopbankoromia.com.et", true, "MALE",
            "07-09-1999", "/image.png", "198.1.13.2", "01-09-2022", null, 1, 0, false, true);
    Users user2 = new Users("939338005", "mahi07", "Mahlet Demeke", "mahletdemeke0791@gmail.com", true, "FEMALE",
            "07-09-1999", "/image.png", "198.1.13.2", "01-09-2022", null, 1, 0, false, true);

  
    Collection<Role> roles = new ArrayList<>();

    void setUp() {
        roles.add(superAdmin);
        user1.setRoles(roles);
        user2.setRoles(roles);
        user1.setAddress(address1);
        user2.setAddress(address2);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, RoleRepository roleRepository,
            AddressRepository addressRepo) {
        setUp();
        return args -> {
            log.info("Preloading " + roleRepository.save(admin));
            log.info("Preloading " + roleRepository.save(superAdmin));
            log.info("Preloading " + roleRepository.save(primaryCooperativeUser));
            log.info("Preloading " + roleRepository.save(unionUser));  
            log.info("Preloading " + userRepository.save(user1));  
            log.info("Preloading " + userRepository.save(user2));
        };
    }
}