package org.example.restdb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired UserRepo ur;

    public Optional<UserData> createUser(String name, String email) {
        ur.save(new UserData(name, email));
        return ur.findByName(name);
    }

    public Optional<UserData> getUserById(long id) {
        return ur.findById(id);
    }

    public List<UserData> getAll() {
        return (List<UserData>) ur.findAll();
    }
}
