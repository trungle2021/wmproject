package com.springboot.wmproject.components.Auth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.wmproject.components.Auth.dto.LoginDTO;
import com.springboot.wmproject.components.Auth.dto.RegisterCustomerDTO;
import com.springboot.wmproject.components.Auth.dto.RegisterDTO;

import java.util.HashMap;

public interface AuthService<T> {
   HashMap<String, String> login(LoginDTO loginDTO);
   T register(T registerDTO);
}