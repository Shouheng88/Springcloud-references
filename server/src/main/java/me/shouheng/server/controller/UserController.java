package me.shouheng.server.controller;

import me.shouheng.comm.model.Task;
import me.shouheng.comm.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author shouh, 2019/6/21-23:26
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/get")
    public List<User> get() {
        return Arrays.asList(new User("User#1", 1), new User("User#2", 2));
    }

    @RequestMapping(value = "/tasks")
    public List<Task> getTasks() {
        List<Task> tasks = restTemplate.getForObject("http://localhost:8099/task/get", List.class);
        logger.info("getTasks {}", tasks);
        return tasks;
    }
}
