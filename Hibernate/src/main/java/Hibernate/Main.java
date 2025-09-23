package Hibernate;

import Hibernate.HibernateConfig;
import Hibernate.TestEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование Hibernate с Java конфигурацией ===");

        try {
            testDatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void testDatabaseConnection() {
        System.out.println("\n--- Тест подключения к БД ---");

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // Проверяем версию PostgreSQL
            String version = session.createNativeQuery("SELECT version()", String.class).getSingleResult();
            System.out.println("✅ Версия PostgreSQL: " + version.split(",")[0]);
            String dbName = session.createNativeQuery("SELECT current_database()", String.class).getSingleResult();
            System.out.println("✅ Текущая БД: " + dbName);
        }
    }
}