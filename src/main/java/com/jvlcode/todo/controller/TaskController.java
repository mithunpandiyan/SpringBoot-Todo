package com.jvlcode.todo.controller;
import com.jvlcode.todo.TaskRepository;
import com.jvlcode.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/tasks")
public class TaskController {

@Autowired
    private TaskRepository taskRepository;
    @GetMapping("/hello-world")
    public  String helloWorld(){
        return "Hello World from code";
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
     taskRepository.save(task);
     return task;
    }
    @GetMapping
    public  List<Task> getAllTasks(){
       return taskRepository.findAll();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task updatedTask){
    updatedTask.setId(id);
     return taskRepository.save(updatedTask);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteTask(@PathVariable Long id){
        try {
            taskRepository.deleteById(id);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete task: " + e.getMessage());
        }
    }

}
