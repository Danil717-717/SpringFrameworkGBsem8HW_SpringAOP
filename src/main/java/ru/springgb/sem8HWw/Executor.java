package ru.springgb.sem8HWw;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "executors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Executor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "executor_name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "task_executers",
            joinColumns = @JoinColumn(name = "executor_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        this.tasks.add(task);

    }

    public void removeTask(long taskId) {
        Task task = this.tasks.stream().filter(t -> t.getId() == taskId)
                .findFirst().orElse(null);
        if (task != null) {
            this.tasks.remove(task);

        }
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
