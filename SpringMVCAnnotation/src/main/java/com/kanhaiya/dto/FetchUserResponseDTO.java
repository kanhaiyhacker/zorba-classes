package com.kanhaiya.dto;

import com.kanhaiya.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchUserResponseDTO {
    private String message;
    private String view;
    private User user;
}
