package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false) Boolean completed) {
        if (completed != null) {
            return taskRepository.findByCompleted(completed);
        }
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setName(taskDetails.getName());
        task.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(task);
    }

    // PATCH endpoint for partial updates
    @PatchMapping("/{id}")
    public ResponseEntity<Task> patchTask(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Task task = taskRepository.findById(id).orElseThrow();

        updates.forEach((key, value) -> {
            switch (key) {
                case "name" -> task.setName((String) value);
                case "completed" -> task.setCompleted((Boolean) value);
                // Add other fields here if your Task has more
            }
        });

        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
