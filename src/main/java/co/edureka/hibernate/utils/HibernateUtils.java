package co.edureka.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private  static SessionFactory sFactory;

    public static  SessionFactory getSessionFactory(){
        if(sFactory == null){

            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml"); // xml Parsing
            sFactory = config.buildSessionFactory();
            return sFactory;
        }
        return sFactory;
    }
}
