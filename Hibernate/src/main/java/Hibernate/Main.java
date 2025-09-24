package Hibernate;

import Hibernate.configs.HibernateConfig;
import Hibernate.entities.Student;
import Hibernate.experiments.Faculty;
import Hibernate.experiments.StudentDAO;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование Hibernate с Java конфигурацией ===");

        try {
            testDatabaseConnection();
            StudentDAO dao = new StudentDAO();
            System.out.println("=== ДЕМО РАБОТЫ СО СТУДЕНТАМИ ===\n");

            System.out.println("СОЗДАЕМ СТУДИКОВ");
            Student student1 = Student.builder()
                    .firstName("Иван")
                    .lastName("Петров")
                    .age(20)
                    .email("ivan.petrov@mail.ru")
                    .faculty(Faculty.COMPUTER_SCIENCE)
                    .build();

            Student student2 = Student.builder()
                    .firstName("Мария")
                    .lastName("Сидорова")
                    .age(19)
                    .email("maria.sidorova@mail.ru")
                    .faculty(Faculty.MATHEMATICS)
                    .build();
            System.out.println("Сохраняем студиков в базу..");
            Long id1 = dao.saveStudent(student1);
            Long id2 = dao.saveStudent(student2);
            Student foundStudent = dao.getStudentById(id1);
            if (foundStudent != null) {
                System.out.println("Найден студент: " + foundStudent);
            }

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