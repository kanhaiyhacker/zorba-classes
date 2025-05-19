package com.kanhaiya.service;

import com.kanhaiya.dto.FetchUserResponseDTO;
import com.kanhaiya.dto.SaveUserResponseDTO;
import com.kanhaiya.dto.UserDto;

public interface UserService {

    SaveUserResponseDTO addUser(UserDto userDto);

    FetchUserResponseDTO loginUser(UserDto userDto);

}
