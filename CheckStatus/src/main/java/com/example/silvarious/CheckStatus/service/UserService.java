package com.example.silvarious.CheckStatus.service;

import com.example.silvarious.CheckStatus.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
       userList = new ArrayList<>();

       User user1 = new User(1,"Vova", 24, "vova@bsuir.by");
       User user2 = new User(2,"Nastya", 18, "nastya@bsuir.by");
       User user3 = new User(3,"Dasha", 17, "dasha@bsuir.by");
       User user4 = new User(4,"Sanya", 10, "sanya@bsuir.by");
       User user5 = new User(5,"Marina", 50, "marina@bsuir.by");

       userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for(User user : userList) {
            if(id == user.getId()) {
                optional = optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
