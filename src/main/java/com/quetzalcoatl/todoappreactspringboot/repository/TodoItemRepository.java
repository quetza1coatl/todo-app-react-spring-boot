package com.quetzalcoatl.todoappreactspringboot.repository;

import com.quetzalcoatl.todoappreactspringboot.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {
}
