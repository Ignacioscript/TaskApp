package edu.UdA.TaskApp.controller;


import edu.UdA.TaskApp.models.Task;
import edu.UdA.TaskApp.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/task")
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }


    @GetMapping("/tasks")
    public List<Task> getTaskList(){
        return this.taskService.getTasks();
    }



    /*public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping({"/taskId"})
    public ResponseEntity<Task> getTask(@PathVariable Long taskId){
        return new ResponseEntity<>(taskService.getTaskById(taskId), HttpStatus.OK);
    }*/


}
