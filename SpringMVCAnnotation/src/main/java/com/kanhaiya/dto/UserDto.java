package com.kanhaiya.dto;

import com.kanhaiya.entity.User;
import com.kanhaiya.entity.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private int userId;
    private long mobile;
    private String name;
    private String address;
    private String username;
    private String password;
    private long ssn;
    private String role;


    public User getUser() {
        User myUser = new User();
        myUser.setUsername(this.username);
        myUser.setSsn(this.ssn);
        myUser.setAddress(this.address);
        myUser.setMobile(this.mobile);
        myUser.setPassword(this.password);
        myUser.setName(this.name);
        Role role = new Role();
        role.setType(this.role);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        myUser.setRoleSet(roleSet);
        return myUser;
    }

}
