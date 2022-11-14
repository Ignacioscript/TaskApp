package edu.UdA.TaskApp.controller;



import edu.UdA.TaskApp.exception.taskNotFoundException;
import edu.UdA.TaskApp.models.Task;
import edu.UdA.TaskApp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/home")
    public String showHomePage() {
        return "homePage";
    }

    @GetMapping("/register")
    public String showTaskRegistration() {
        return "registerTaskPage";
    }

    @PostMapping("/save")
    public String saveTask(
            @ModelAttribute Task task,
            Model model
    ) {
        taskService.insert(task);
        long id = taskService.insert(task).getIdTask();
        String message = "Record with id : '" + id + "' is saved successfully !";
        model.addAttribute("message", message);
        return "registerTaskPage";
    }

    @GetMapping("/getAllTasks")
    public String getAllTasks(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<Task> tasks = taskService.getTasks();
        model.addAttribute("list", tasks);
        model.addAttribute("message", message);
        return "allTasksPage";
    }

    @GetMapping("/edit")
    public String getEditTaskPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam Long id
    ) {
        String page;
        try {
            Task task = taskService.getTaskById(id);
            model.addAttribute("Task", task);
            page = "editTaskPage";
        } catch (taskNotFoundException e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
            page = "redirect:getAllTasks";
        }
        return page;
    }

    @PostMapping("/update")
    public String updateTask(
            @ModelAttribute Task task,
            RedirectAttributes attributes
    ) {
        Long id = null;
        taskService.updateTask(id, task);
        id = task.getIdTask();
        attributes.addAttribute("message", "Task with id: '" + id + "' is updated successfully !");
        return "redirect:getAllTasks";
    }

    @GetMapping("/delete")
    public String deleteTask(
            @RequestParam Long id,
            RedirectAttributes attributes
    ) {
        try {
            taskService.deleteTask(id);
            attributes.addAttribute("message", "Task with Id : '" + id + "' is removed successfully!");
        } catch (taskNotFoundException e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
        }
        return "redirect:getAllTasks";
    }





}
