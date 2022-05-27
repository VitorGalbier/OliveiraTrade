package com.Login.OliveiraTrade.Controller;

import com.Login.OliveiraTrade.Model.User;
import com.Login.OliveiraTrade.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<String> post (@RequestBody User user){
        service.create(user);
        return ResponseEntity.ok("Usuário criado com sucesso!");
    }

    @PutMapping("/update")
    public User put(@RequestBody User user){
        return service.update(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity <User> getById(@RequestParam Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
}
