package com.example.ToDo.Repository;

import com.example.ToDo.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo,Long> {


}
