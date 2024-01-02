/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sumdu.model.Student;

/**
 *
 * @author bogda
 */


@Repository ("StudentDAO")
@EnableTransactionManagement
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addStudent (Student a) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.save(a);
    }
    
    @Transactional
    public List<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student").list();
    }

}

