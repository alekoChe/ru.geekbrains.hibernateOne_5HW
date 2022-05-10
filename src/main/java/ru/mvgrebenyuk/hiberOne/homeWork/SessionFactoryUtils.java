package ru.mvgrebenyuk.hiberOne.homeWork;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
    private SessionFactory factory;

    public void init(){
        factory = new Configuration()
                .configure("hibfernate2.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSession(){
        return factory.getCurrentSession();
    }

    public void shotdown(){
        if(factory != null){
            factory.close();
        }
    }

}
