package co.edureka.hibernate;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Scanner;

public class SearchStudent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    SessionFactory sFactory = HibernateUtils.getSessionFactory();
    Session session = sFactory.openSession();
//    Transaction tx = session.beginTransaction();

        Student st = new Student();
        System.out.println("Enter Your search Id :");
        int id = sc.nextInt();
        try{
            session.load(st,id);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        System.out.println(st);
        session.close();
        sFactory.close();

    }

}
