package edu.UdA.TaskApp.repositories;

import edu.UdA.TaskApp.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
