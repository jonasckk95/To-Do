package com.example.todo.services;

import com.example.todo.model.todo;
import com.example.todo.repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class todoServicesImpl implements todoService {

    private final todoRepository todoRepository;

    public todoServicesImpl(todoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public todo getTodo(int id) {
        Optional<todo> todo = todoRepository.findById(id);
        return todo.orElse(null);
    }

    @Override
    public todo storeTodo(todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public boolean deleteTodo(int id) {
        boolean deleted = false;
        Optional<todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
            deleted = true;
        }
        return deleted;
    }
}