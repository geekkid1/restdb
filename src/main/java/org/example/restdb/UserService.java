package org.example.restdb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired UserRepo ur;

    public UserData createUser(String name, String email) {
        UserData ud = new UserData(name, email);
        ur.save(ud);
        return ud;
    }

    public Optional<UserData> getUserById(long id) {
        return ur.findById(id);
    }

    public List<UserData> getAll() {
        return (List<UserData>) ur.findAll();
    }
}
