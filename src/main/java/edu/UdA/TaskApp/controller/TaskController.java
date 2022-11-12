package edu.UdA.TaskApp.controller;


import edu.UdA.TaskApp.models.Task;
import edu.UdA.TaskApp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/ViewTasks")
    public String viewTasks(Model model){
        List<Task> taskList = taskService.getTasks();
        model.addAttribute("taskList", taskList);
        return "tasks";
    }



}
