package com.example.BookMyShow.Transforms;

import com.example.BookMyShow.DTO.AddUserRequest;
import com.example.BookMyShow.Modals.User;

public class UserTransforms {
    public static User convertAddUserRequestToUserEntity(AddUserRequest addUserRequest){
        User userObj= User.builder()
                .userName(addUserRequest.getUserName())
                .age(addUserRequest.getAge())
                .emailId(addUserRequest.getEmailId())
                .mobileNumber(addUserRequest.getMobileNumber())
                .build();

        return userObj;
    }
}
