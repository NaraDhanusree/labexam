package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        // Configure Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Insert records
        Transaction transaction = session.beginTransaction();
        Client client1 = new Client();
        client1.setName("Alice");
        client1.setGender("Female");
        client1.setAge(25);
        client1.setLocation("New York");
        client1.setEmail("alice@example.com");
        client1.setMobile("1234567890");

        Client client2 = new Client();
        client2.setName("Bob");
        client2.setGender("Male");
        client2.setAge(30);
        client2.setLocation("Los Angeles");
        client2.setEmail("bob@example.com");
        client2.setMobile("0987654321");

        session.save(client1);
        session.save(client2);
        transaction.commit();

        // Print all records
        List<Client> clients = session.createQuery("from Client", Client.class).getResultList();
        for (Client client : clients) {
            System.out.println(client);
        }

        session.close();
        sessionFactory.close();
    }
}
