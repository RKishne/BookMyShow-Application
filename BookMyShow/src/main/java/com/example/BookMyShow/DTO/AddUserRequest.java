package com.example.BookMyShow.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {

    private String userName;

    private int age;

    private String emailId;

    private String mobileNumber;
}
