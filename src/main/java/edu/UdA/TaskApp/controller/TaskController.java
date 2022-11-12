package edu.UdA.TaskApp.controller;


import edu.UdA.TaskApp.models.Task;
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

    @GetMapping("/ViewTasks")
    public String viewTasks(Model model){
        List<Task> taskList = taskService.getTasks();
        model.addAttribute("taskList", taskList);
        return "viewTasks";
    }

    //SERVICIO PARA AGREGAR Task
    @GetMapping("/AddTask")
    public String newTask(Model model){
        Task task = new Task();
        model.addAttribute("task",task);
        return "addTask";
    }

    //SERVICIO PARA GUARDAR Task
    @PostMapping("/SaveTask")
    public String saveTask(Task task, RedirectAttributes redirectAttributes){
        try{
            taskService.insert(task);
        }catch (Exception e){
            return "redirect:/ViewTasks";
        }
        return "redirect:AddTasks";
    }

    //SERVICIO PARA EDITAR Task
    @GetMapping("/EditTask/{id}")
    public String editTask(Model model, @PathVariable Long id){
        Task task = taskService.getTaskById(id);
        model.addAttribute("task",task);
        return "editTask";

    }

    //SERVICIO PARA ACTUALIZAR Task
    @PostMapping("/UpdateTask")
    public String updateTask(Long id, Task task){
        try{
            taskService.updateTask(id, task);
        }catch (Exception e){
            return "redirect:/ViewTasks";
        }
        return "redirect:EditTasks";
    }

    //SERVICIO PARA ELIMINAR Task
    @GetMapping("/DeleteTask/{id}")
    public String deleteTask(@PathVariable Long id){
        try{
            taskService.deleteTask(id);
        }catch (Exception e){
            return "redirect:/ViewTasks";
        }
        return "redirect:ViewTasks";
    }




}
