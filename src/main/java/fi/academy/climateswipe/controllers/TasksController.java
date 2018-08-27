package fi.academy.climateswipe.controllers;
import fi.academy.climateswipe.entities.Tasks;
import fi.academy.climateswipe.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private TasksRepository tasksRepository;

    @Autowired
    public TasksController(
            TasksRepository TasksRepository) {
        this.tasksRepository = TasksRepository;
    }

    @GetMapping("/task/{id}")
    public Optional<Tasks> show(@PathVariable Integer id) {
        return tasksRepository.findById(id);
    }

    @GetMapping
    public Iterable<Tasks> contact() {
        return tasksRepository.findAll();
    }

}
