package co.edureka;


import co.edureka.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveStudent {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml"); // xml Parsing

        SessionFactory sFactory = config.buildSessionFactory();
        Session session = sFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student st = new Student();
        st.setStudentId(1);
        st.setStudentName("koko");
        st.setStudentEmail("koko@gmail.com");
        session.save(st);
        tx.commit();
        session.close();

    }
}