package edu.UdA.TaskApp.services;

import edu.UdA.TaskApp.models.Task;


import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTaskById(Long id);

    Task insert(Task task);

    void  updateTask(Long id, Task task);

    void deleteTask(Long taskId);
}
