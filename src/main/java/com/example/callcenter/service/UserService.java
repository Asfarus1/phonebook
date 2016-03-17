package com.example.callcenter.service;

import com.example.callcenter.model.UserModel;
import com.example.callcenter.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UserService extends BaseService<UserModel, UserRepository> {
}
