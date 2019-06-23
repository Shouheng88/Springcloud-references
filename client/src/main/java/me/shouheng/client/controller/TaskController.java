package me.shouheng.client.controller;

import me.shouheng.comm.model.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author shouh, 2019/6/21-23:27
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @RequestMapping(value = "/get")
    public List<Task> get() {
        return Arrays.asList(new Task("Task#1", "Detail#1"), new Task("Task#2", "Detail#2"));
    }
}
