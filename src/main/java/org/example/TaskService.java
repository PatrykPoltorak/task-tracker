package org.example;

import java.time.LocalDateTime;

public class TaskService {
    public TaskService(){

    }

    void addTask(int id,String description){
        Task task = new Task(id, description);
        task.setStatus(Status.TODO);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
    }
    void updateTask(int id, String description){
        Task task = findTaskById(id);
        task.setDescription(description);
        task.setUpdatedAt(LocalDateTime.now());
    }

    Task findTaskById(int id){
        Task task;
        return task;
    }
}
