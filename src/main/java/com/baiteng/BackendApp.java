package com.baiteng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：gaozhixing
 * @date ：Created in 2019/7/4 19:23
 * @description：
 * @modified By：
 * @version:
 */
@SpringBootApplication
public class BackendApp {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication app = new SpringApplication(BackendApp.class);
        app.run(args);
    }
}
