package com.example.todo.controller;

import com.example.todo.model.todo;
import com.example.todo.services.todoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("todo")
@RestController
public class todoController {

    private final todoService todoService;

    @Autowired
    public todoController(todoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<todo> getTodoList() {
        return todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<todo> getTodo(@PathVariable("id") int id) {
        todo todo = todoService.getTodo(id);
        return todo != null ? new ResponseEntity<>(todo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> storeTodo(@RequestBody todo todo) {
        return todoService.storeTodo(todo) != null ? new ResponseEntity<>("Saved Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Saved Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> storeTodo(@PathVariable("id") int id, @RequestBody todo todo) {
        todo exTodo = todoService.getTodo(id);
        todo.setId(id);
        return exTodo != null ? todoService.storeTodo(todo) != null
                ? new ResponseEntity<>("Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") int id) {
        todo exTodo = todoService.getTodo(id);
        return exTodo != null ? todoService.deleteTodo(id)
                ? new ResponseEntity<>("Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
