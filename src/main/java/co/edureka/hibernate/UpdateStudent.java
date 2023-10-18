package co.edureka.hibernate;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class UpdateStudent {

    public static void main(String[] args) {

    SessionFactory sFactory = HibernateUtils.getSessionFactory();
        Scanner sc = new Scanner(System.in);
        Session session = sFactory.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("Enter Student Id, name , and email you want to edit");
        int id = sc.nextInt();
        String name = sc.next();
        String email = sc.next();
        Student st = new Student(id,name, email);
        session.update(st);
        session.getTransaction().commit();
        session.close();
        sFactory.close();
    }
}
