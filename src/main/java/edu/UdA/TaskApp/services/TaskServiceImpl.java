package edu.UdA.TaskApp.services;

import edu.UdA.TaskApp.models.Task;
import edu.UdA.TaskApp.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task insert(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task taskFromDb = taskRepository.findById(id).get();
        System.out.println(taskFromDb.toString());
        taskFromDb.setState(task.getState());
        taskFromDb.setDescription(task.getDescription());
        taskFromDb.setTitle(task.getTitle());
        taskRepository.save(taskFromDb);
        return taskFromDb;
    }

    @Override
    public boolean deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
        return true;
    }
}
