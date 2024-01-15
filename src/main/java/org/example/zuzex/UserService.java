package org.example.zuzex;

public interface UserService {

    House_user getUser(Long id);
    House_user createUser(House_user user);
    House_user updateUser(Long id,House_user user);
    void deleteUser(Long id);
}
