package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import Hibernate.TestEntity;
import Hibernate.Student;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Создаем конфигурацию
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://192.168.0.104:5432/mydb");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "pspKxavk2");
            configuration.setProperty("hibernate.connection.pool_size", "10");
            configuration.setProperty("hibernate.connection.autocommit", "false");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");
            configuration.setProperty("hibernate.highlight_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.current_session_context_class", "thread");
            configuration.addAnnotatedClass(TestEntity.class);
            configuration.addAnnotatedClass(Student.class);
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            // Создаем SessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);


        } catch (Throwable ex) {
            System.err.println("❌ Ошибка инициализации Hibernate: " + ex.getMessage());
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            throw new IllegalStateException("SessionFactory не инициализирована");
        }
        return sessionFactory;
    }
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("✅ SessionFactory закрыт");
        }
    }
}
