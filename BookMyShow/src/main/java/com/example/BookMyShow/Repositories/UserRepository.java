package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Modals.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
