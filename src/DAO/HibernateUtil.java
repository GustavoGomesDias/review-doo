package DAO;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    public static SessionFactory getSession() {
        try {
            Configuration configuration = new Configuration();
        return configuration
                .configure()
                .buildSessionFactory(new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build()
                );
        } catch (HibernateException err) {
            throw new ExceptionInInitializerError(err);
        }
    }
    
}
