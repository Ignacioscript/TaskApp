package edu.UdA.TaskApp.services;

import edu.UdA.TaskApp.models.Task;


import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTaskById(Long id);

    Task insert(Task task);

    Task updateTask(Long id, Task task);

    boolean deleteTask(Long taskId);
}
