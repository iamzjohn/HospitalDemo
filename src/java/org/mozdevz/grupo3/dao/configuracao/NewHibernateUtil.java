/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.dao.configuracao;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Adelino Jose
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

//                File hibernateConfigFile = new File(System.getProperty("user.dir")+ "/hibernate.cfg.xml");
                File hibernateConfigFile = new File("hibernate.cfg.xml");
                Configuration configuration  = new Configuration().configure(hibernateConfigFile);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Falha ao tentar inicializar a sessao da base de dados!!!".toUpperCase() + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
