package com.taco.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h3>Main class</h3>
 *
 * Taco Cloud runs from this class
 */
@SpringBootApplication
public class TacoCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
        HomeController homeController = new HomeController();
        homeController.home();
    }
}
