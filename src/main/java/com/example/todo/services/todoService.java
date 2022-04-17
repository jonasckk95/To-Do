package com.example.todo.services;

import com.example.todo.model.todo;

import java.util.List;

public interface todoService {

    List<todo> getTodoList();

    todo getTodo(int id);

    todo storeTodo(todo todo);

    boolean deleteTodo(int id);

}
