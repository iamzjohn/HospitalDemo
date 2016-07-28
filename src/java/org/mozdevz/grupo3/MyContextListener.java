package org.mozdevz.grupo3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;
import org.mozdevz.grupo3.dao.DAOAbstracto;
import org.mozdevz.grupo3.dao.configuracao.NewHibernateUtil;

public class MyContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
//        new DAOAbstracto<Object>(sessionFactory.openSession());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       
    }
    
}
