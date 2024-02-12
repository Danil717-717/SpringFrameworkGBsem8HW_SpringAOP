package ru.springgb.sem8HWw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.springgb.sem8HWw.Executor;
import ru.springgb.sem8HWw.logAspect.TrackUserAction;
import ru.springgb.sem8HWw.repository.ExecutorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExecutorServiceImpl implements ExecutorService {

    private final ExecutorRepository repository;

    @Override
    public List<Executor> findAll() {
        return repository.findAll();
    }

    @Override
    public Executor findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader not found"));
    }

    @TrackUserAction
    @Override
    public Executor save(Executor executor) {
        return repository.save(executor);
    }

    public Executor getExecutor(Long id) {
        return findAll().stream().filter(executor  -> executor.getId().equals(id)).findFirst().orElse(null);
    }


    @TrackUserAction
    @Override
    public Executor updateExecutor(Long id, Executor executor) {
        Executor executorStaraya = getExecutor(id);
        if (executorStaraya != null) {
            executorStaraya.setName(executor.getName());
            executorStaraya.setTasks(executor.getTasks());
        }
        return executorStaraya;
    }

    @TrackUserAction
    @Override
    public Executor apdateExecutor(Executor executor) {
        return repository.save(executor);
    }


    @TrackUserAction
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
