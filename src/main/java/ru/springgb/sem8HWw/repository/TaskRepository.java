package ru.springgb.sem8HWw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springgb.sem8HWw.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
