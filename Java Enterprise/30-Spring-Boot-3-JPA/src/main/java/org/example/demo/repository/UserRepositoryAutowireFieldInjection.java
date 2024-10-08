package org.example.demo.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.ToString;
import org.example.demo.domain.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@ToString
public class UserRepositoryAutowireFieldInjection {


//    bad practice -> change to constructor injection
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    @Qualifier("connectionPool1")
    private ConnectionPool connectionPool;

    @Value("${db.pool.size}")
    private Integer poolSize;

//      bad practice -> change to constructor injection
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    @Qualifier("connectionPool2")
    private List<ConnectionPool> connectionPool2;



    // replaces xml init-method
    @PostConstruct
    public void init(){
        System.out.println("Initialize UserRepository");
    }

    // replaces xml destroy-method
    @PreDestroy
    public void destroy(){
        System.out.println("Destroy UserRepository");
    }
}
