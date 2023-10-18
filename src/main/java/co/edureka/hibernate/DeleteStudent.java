package co.edureka.hibernate;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class DeleteStudent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();

        System.out.println("Enter Your student ID to Delete: ");
        int id = sc.nextInt();
       Student st = session.get(Student.class, id);
       try{
           if(st != null){
               session.delete(st);
               System.out.println("Student's " + st + "is deleted");
           }
       }catch (Exception e){
           System.out.println(e);
       }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

}
