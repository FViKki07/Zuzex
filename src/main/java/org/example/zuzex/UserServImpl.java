package org.example.zuzex;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public House_user getUser(Long id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("House not found"));
    }

    @Override
    public House_user createUser(House_user user){
        return userRepo.save(user);
    }

    @Override
    public House_user updateUser(Long id, House_user edit_user){
        House_user user = userRepo.findById(id).get();
        user.setName_user(edit_user.getName_user());
        user.setAge(edit_user.getAge());
        user.setPassword(edit_user.getPassword());

        return userRepo.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
