package com.mizlicai.eudemon.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by huangyt on 2017/6/6.
 */
public class TaskEudemonStartup {

    public TaskEudemonStartup() {
    }

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        context.start();
        System.out.println("Pleas print any key ....");
        System.in.read();
    }
}
