package com.andrewkeddis.getthingsdone;

import com.andrewkeddis.getthingsdone.dao.TaskDao;
import com.andrewkeddis.getthingsdone.models.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Profile("enableGetThingsDoneDataLoader")
@Component
public class GetThingsDoneDataLoader implements CommandLineRunner {
    private final TaskDao taskDao;
    private List<Task> tasksToLoad = new ArrayList<>();

    public GetThingsDoneDataLoader(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Transactional
    @Override
    public void run(String... args) {
        taskDao.save(
                Task.builder()
                        .title("Have Breakfast")
                        .description("Breakfast is the most important meal of the day. This is a very important task for the day")
                        .category("Personal")
                        .deadline(new GregorianCalendar())
                        .priority(1)
                        .status("Not Started")
                        .pending(true)
                        .display(true)
                        .createdAt(new GregorianCalendar())
                        .creatorId("123456")
                        .build()
        );
        taskDao.save(
                Task.builder()
                        .title("Check the mail")
                        .description("I am expecting a package from Amazon this week. Need to check the mail today")
                        .category("Personal")
                        .deadline(new GregorianCalendar())
                        .priority(4)
                        .status("Not Started")
                        .pending(true)
                        .display(true)
                        .createdAt(new GregorianCalendar())
                        .creatorId("123456")
                        .build()
        );
        taskDao.save(
                Task.builder()
                        .title("Develop the todo app")
                        .description("It's important to keep learning and self developing. Build the todo app to learn apis")
                        .category("Education")
                        .deadline(new GregorianCalendar(2020, 9, 15))
                        .priority(7)
                        .status("Not Started")
                        .pending(true)
                        .display(true)
                        .createdAt(new GregorianCalendar())
                        .creatorId("123456")
                        .build()
        );
        taskDao.save(
                Task.builder()
                        .title("Work Task")
                        .description("This task is related to work. There is a deadline coming up to deliver the project")
                        .category("Work")
                        .deadline(new GregorianCalendar(2020, 6, 15))
                        .priority(5)
                        .status("Not Started")
                        .pending(true)
                        .display(true)
                        .createdAt(new GregorianCalendar())
                        .creatorId("123456")
                        .build()
        );
    }
}
