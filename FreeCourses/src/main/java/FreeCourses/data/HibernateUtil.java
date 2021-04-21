/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.data;

/**
 *
 * @author felig
 */

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import FreeCourses.logic.*;



/**
 * Java based configuration
 * @author ramesh Fadatare
 *
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    /**
     * Class utils for connection to the database using Hibernate
     *
     * @return sessionFactory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3307/cursos_libres?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create");

                // IMPORTANT HBM2DDL_AUTO +++++++++++++
                // validate: validate the schema, makes no changes to the database.
                // update: update the schema.
                // create: creates the schema, destroying previous data.
                // create-drop: drop the schema when the SessionFactory is closed explicitly, typically when the application is stopped.
                // none: does nothing with the schema, makes no changes to the database

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Administrator.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Enrollment.class);
                configuration.addAnnotatedClass(Section.class);
                configuration.addAnnotatedClass(Professor.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}