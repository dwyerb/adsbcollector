package net.muroc.adsbcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdsbcollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsbcollectorApplication.class, args);
    }

}
