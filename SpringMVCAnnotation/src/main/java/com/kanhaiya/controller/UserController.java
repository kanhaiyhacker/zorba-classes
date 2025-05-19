package com.kanhaiya.controller;

import com.kanhaiya.dto.FetchUserResponseDTO;
import com.kanhaiya.dto.SaveUserResponseDTO;
import com.kanhaiya.dto.UserDto;
import com.kanhaiya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public void restMapping() {
        System.out.println("test mapping is called");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute UserDto userDto) {
        System.out.println(userDto);
        SaveUserResponseDTO result = userService.addUser(userDto);
        ModelAndView modelAndView = new ModelAndView(result.getView());
        modelAndView.addObject("message", result.getMessage());
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterView() {
        return new ModelAndView("registerUser");
    }

    @GetMapping("/login")
    public ModelAndView getLoginView() {
        return new ModelAndView("loginUser");
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@ModelAttribute UserDto userDto) {
        System.out.println(userDto);
        FetchUserResponseDTO result = userService.loginUser(userDto);
        ModelAndView modelAndView = new ModelAndView(result.getView());
        modelAndView.addObject("message", result.getMessage());
        return modelAndView;
    }
}
