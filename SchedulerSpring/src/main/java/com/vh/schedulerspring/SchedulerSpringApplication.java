package com.vh.schedulerspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

import static java.lang.Thread.*;

@SpringBootApplication
@EnableScheduling
public class SchedulerSpringApplication {

    Logger logger = LoggerFactory.getLogger(SchedulerSpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SchedulerSpringApplication.class, args);
    }

    @Scheduled(cron = "*/2 * * * * *")
    public void Job() throws InterruptedException {
        logger.info("Job Current Time " + new Date());
        Thread.sleep(1000L);
    }

}
