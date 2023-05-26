package example;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//fix secure password with exclude=...
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}