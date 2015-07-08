package com.mttch.admin.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableAspectJAutoProxy
@ImportResource({"classpath*:applicationContext.xml"})
public class ServerApplication {

    final static Logger logger = LoggerFactory.getLogger(ServerApplication.class);

    @Autowired
    Environment env;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
