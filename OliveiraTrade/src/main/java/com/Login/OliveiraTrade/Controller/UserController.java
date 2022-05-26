package com.Login.OliveiraTrade.Controller;

import com.Login.OliveiraTrade.Model.User;
import com.Login.OliveiraTrade.Service.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Create")
public class UserController {
    @Autowired
    private UserCreateService service;

    @PostMapping()
    public User post (@RequestBody User user){
        return service.create(user);
    }

    @PutMapping
    public User put(@RequestBody User user){
        return service.update(user);
    }

}
