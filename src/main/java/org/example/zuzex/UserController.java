package org.example.zuzex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.query.Param;

@RestController
@RequestMapping("/home")
public class UserController {

    @Autowired
    UserService userServ;

    @GetMapping("/user/{id}")
    public House_user getUser(@PathVariable("id") Long id){
        return userServ.getUser(id);
    }

    @PostMapping("/user")
    public House_user createUser(@RequestBody House_user user){
        return userServ.createUser(user);
    }

    @PutMapping("/user/{id}")
    public House_user updateUser(@PathVariable("id") Long id,@RequestBody House_user user){
        return userServ.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUSer(@PathVariable("id") Long id){
        userServ.deleteUser(id);
    }

}
