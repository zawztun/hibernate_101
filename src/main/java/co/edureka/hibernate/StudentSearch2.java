package co.edureka.hibernate;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class StudentSearch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory sFactory = HibernateUtils.getSessionFactory();

        Session session = sFactory.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("Enter Id number for Search : ");
        int id = sc.nextInt();
       Student st =  session.get(Student.class,id);
        if(st != null ){
            System.out.println(st);
        }else {
            System.out.println("Student ID not Match:");
        }
    session.close();
        sFactory.close();
    }
}
