package co.edureka.hibernate;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Scanner;

public class SaveStudents {

    public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
        SessionFactory sFactory = HibernateUtils.getSessionFactory();

        Session session = sFactory.openSession();
        Transaction tx = session.beginTransaction();

        String req = "Y";

        do {
            System.out.println("enter student name & email:");
            String name = sc.next();
            String email = sc.next();

            Student st = new Student(name, email);
            //session.save(st);
            Serializable sid = session.save(st);
            System.out.println("student with student id: " + sid + " saved...");

            System.out.print("\ndo you want to save more students[Y/N]: ");
            req = sc.next();
        } while(req.equalsIgnoreCase("Y"));

        System.out.println();

        tx.commit();

        session.close();
        sFactory.close();


    }


}

