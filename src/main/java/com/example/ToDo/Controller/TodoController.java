package com.example.ToDo.Controller;

import com.example.ToDo.Model.Todo;
import com.example.ToDo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.listTodos();
    }

    @PutMapping("/{id}")
    public Todo updateTodoStatus(@PathVariable Long id, @RequestBody Todo todoDetails) {
        return todoService.updateTodoStatus(id, todoDetails.isCompleted());
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }
}
