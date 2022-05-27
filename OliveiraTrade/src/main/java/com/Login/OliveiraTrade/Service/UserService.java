package com.Login.OliveiraTrade.Service;

import com.Login.OliveiraTrade.Repository.UserRepository;
import com.Login.OliveiraTrade.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CreateService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create (User user){
        return userRepository.save(user);
    }

    public User update (User user){
        User userUpdate = userRepository.findById(user.getId()).get();
        userUpdate.setPassword(user.getPassword());

        return userRepository.save(userUpdate);
    }

    public User getById(Integer id){
        return userRepository.findById(id).get();
    }

}
