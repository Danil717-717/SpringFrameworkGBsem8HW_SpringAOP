package ru.springgb.sem8HWw.service;

import org.springframework.stereotype.Service;
import ru.springgb.sem8HWw.Executor;

import java.util.List;

@Service
public interface ExecutorService {
    List<Executor> findAll();

    Executor findById(Long id);
    Executor save(Executor executor);

    Executor updateExecutor(Long id, Executor executor);
    Executor apdateExecutor(Executor executor);

    void deleteById(Long id);

}
