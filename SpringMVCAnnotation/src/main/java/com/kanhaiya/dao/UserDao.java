package com.kanhaiya.dao;

import com.kanhaiya.entity.Role;
import com.kanhaiya.entity.User;

public interface UserDao {
    void saveUser(User myUser);

    User getUser(String userName, String password, String roleType);

    boolean checkIsUsernameAlreadyExist(String userName);

    Role checkIfRole(Role role);
}
