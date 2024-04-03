package com.jvlcode.todo;

import com.jvlcode.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
