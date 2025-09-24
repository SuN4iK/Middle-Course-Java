package Hibernate.experiments;

import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Persistence
                .createEntityManagerFactory("students-h2")
                .unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
    }
}
