package com.example.todo.repository;

import com.example.todo.model.todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface todoRepository extends JpaRepository<todo, Integer> {
}