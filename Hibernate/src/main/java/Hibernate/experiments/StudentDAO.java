package Hibernate.experiments;

import Hibernate.configs.HibernateConfig;
import Hibernate.entities.Student;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDAO {
    public Long saveStudent(Student student) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        Long studentId = null;

        try {
            transaction = session.beginTransaction();
            studentId = (Long) session.save(student);
            transaction.commit();
            System.out.println("Студент сохранен: " + studentId);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Ошибка при транзакции" + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentId;
    }
    public Student getStudentById(Long id) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Student student = null;

        try {
            student = (Student) session.get(Student.class, id);
            if (student != null) {
                System.out.println("Найден студент: " + student);
            } else {
                System.out.println("Студент не найден");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при поиске студента:" + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }
    public List<Student> getAllStudents() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        List<Student> students = null;

        try {
            students = session.createQuery("FROM Student", Student.class).list();
            System.out.println("Найдено студентов: " + students.size());
        } catch (Exception e) {
            System.err.println("Ошибка при получении студентов: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }
    public List<Student> findAllWithJPQL() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            String jpql = "SELECT s FROM Student s";
            // 4. Создаем типизированный запрос
            // session.createQuery() - метод Hibernate для JPQL
            // Student.class - указываем, что ожидаем объекты Student
            TypedQuery<Student> query = session.createQuery(jpql, Student.class);
            // 5. Выполняем запрос и возвращаем результат
            // getResultList() - получаем все записи
            return query.getResultList();
            // 6. Закрываем сессию в любом случае (даже если была ошибка)
            // Важно для освобождения ресурсов
        } finally {
            session.close();
        }
    }
    public List<Student> findStudentsOlderThanJPQL(int age) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            String jpql = "SELECT s FROM Student s WHERE s.age > :minAge ORDER BY s.age DESC";
            TypedQuery<Student> query = session.createQuery(jpql, Student.class);
            query.setParameter("minAge", age);
            return query.getResultList();
        } finally {
            session.close();
        }
    }
}
