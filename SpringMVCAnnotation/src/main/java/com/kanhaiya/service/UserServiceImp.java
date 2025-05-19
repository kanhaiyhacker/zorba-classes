package com.kanhaiya.service;

import com.kanhaiya.dao.UserDao;
import com.kanhaiya.dto.FetchUserResponseDTO;
import com.kanhaiya.dto.SaveUserResponseDTO;
import com.kanhaiya.dto.UserDto;
import com.kanhaiya.entity.User;
import com.kanhaiya.entity.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public SaveUserResponseDTO addUser(UserDto userDto) {
        SaveUserResponseDTO response = new SaveUserResponseDTO();
        User myUser = userDto.getUser();
        try {
            boolean isUserAlreadyExist = userDao.checkIsUsernameAlreadyExist(userDto.getUsername());
            if (isUserAlreadyExist) {
                response.setMessage("username already exist.");
                response.setView("error");
                return response;
            }
            Set<Role> roleSet = new HashSet<>();
            for (Role role : myUser.getRoleSet()) {
                Role role1 = userDao.checkIfRole(role);
                roleSet.add(role1);
            }
            myUser.setRoleSet(roleSet);
            userDao.saveUser(myUser);
            response.setMessage("Save user data to db.");
            response.setView("success");
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setView("error");
            return response;
        }
    }

    @Override
    public FetchUserResponseDTO loginUser(UserDto userDto) {
        FetchUserResponseDTO response = new FetchUserResponseDTO();
        response.setView("error");
        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            response.setMessage("Password cannot be empty.");
            return response;
        }
        if (userDto.getUsername() == null || userDto.getUsername().isEmpty()) {
            response.setMessage("Username cannot be empty.");
            return response;
        }
        try {
            User myUser = userDao.getUser(userDto.getUsername(), userDto.getPassword(), userDto.getRole());
            if (myUser != null) {
                for (Role role : myUser.getRoleSet()) {
                    if (role.getType().equalsIgnoreCase(userDto.getRole())) {
                        response.setMessage("User is " + myUser.getName() + ". Login successfully!!");
                        response.setView("success");
                        return response;
                    }
                }
                response.setMessage("User is " + myUser.getName() + ".It does have " + userDto.getRole() + " role");
                response.setView("error");
                return response;
            }
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return response;
        }
        response.setMessage("something want wrong...");
        return response;
    }
}
