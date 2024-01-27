package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class Util {
    // реализуйте настройку соеденения с БД
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        //if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/katapp1?useSSL=false&serverTimezone=UTC");
                configuration.setProperty("hibernate.connection.username", "root");
                configuration.setProperty("hibernate.connection.password", "$0101MMa");

                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                configuration.setProperty("hibernate.show_sql", "true");
                configuration.setProperty("hibernate.hbm2ddl.auto", "update");

                configuration.addAnnotatedClass(User.class);

                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                registryBuilder.applySettings(configuration.getProperties());
                return configuration.buildSessionFactory(registryBuilder.build());

            } catch (Exception e) {
                e.printStackTrace();
                throw new ExceptionInInitializerError(e);
            }
        }
        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }

