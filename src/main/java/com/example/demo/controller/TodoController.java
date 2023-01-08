package com.example.demo.controller;

import com.example.demo.entity.TodoEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity createTodo (@RequestBody TodoEntity todo,
                                      @RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo (@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.completeTodo(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
