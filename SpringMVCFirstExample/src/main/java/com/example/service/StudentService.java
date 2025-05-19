package com.example.service;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String testService() {
        return "From Service";
    }
}