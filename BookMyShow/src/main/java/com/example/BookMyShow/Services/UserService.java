package com.example.BookMyShow.Services;

import com.example.BookMyShow.DTO.AddUserRequest;
import com.example.BookMyShow.Modals.User;
import com.example.BookMyShow.Repositories.UserRepository;
import com.example.BookMyShow.Transforms.UserTransforms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserRequest addUserRequest) {

        User userObj= UserTransforms.convertAddUserRequestToUserEntity(addUserRequest);

        userRepository.save(userObj);
        return "User has been added successfully in the DB.";
    }
}
