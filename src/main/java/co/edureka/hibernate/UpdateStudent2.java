package co.edureka.hibernate;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Scanner;

public class UpdateStudent2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter student ID, name and email you want to update:  ");
      Serializable id = sc.nextInt();
        String name = sc.next();
        String email = sc.next();
        Student st = session.get(Student.class, id);
        if(st != null){
          st.setStudentName(name);
          st.setStudentEmail(email);
        session.update(st);
        }else{
            System.out.println("Can not Update Student Info: ");
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
