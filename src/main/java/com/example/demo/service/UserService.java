package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration (UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) !=null){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne (Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null)
            throw new UserNotFoundException("Пользователь с таким id не найден");
        return User.toModel(user);
    }

    public Long deleteUser (Long id){
        userRepo.deleteById(id);
        return id;
    }

}
