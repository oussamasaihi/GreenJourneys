package com.greenjourneys.schedular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {
    private static final Logger log = LoggerFactory.getLogger(Schedular.class);

    public Schedular() {
    }

    @Scheduled(
            cron = "* 1 * * * * "
    )
    private void scheduledExample() {
        System.out.println("this is my scheduled task");
    }
}
