package com.Login.OliveiraTrade.Repository;

import com.Login.OliveiraTrade.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String email);
}
