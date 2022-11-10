package edu.UdA.TaskApp.controller;


import edu.UdA.TaskApp.models.Task;
import edu.UdA.TaskApp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/tasks")
    public List<Task> getTaskList() {
        return this.taskService.getTasks();
    }

    @GetMapping(path = "/task/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return this.taskService.getTaskById(id);
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.insert(task);
    }

    @PatchMapping("/task/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable("id") long id) {
        boolean response = taskService.deleteTask(id);
        if (response) {
            return "se eliminó con éxito";
        } else {
            return "No se pudo eliminar";
        }
    }


}
