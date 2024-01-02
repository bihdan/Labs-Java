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
import sumdu.model.student_Marks;

/**
 *
 * @author bogda
 */

@Repository ("MarkDAO")
@EnableTransactionManagement
public class MarkDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Student getStudent(int Id){
        Session session = sessionFactory.getCurrentSession();

    String hql = "FROM Student WHERE id = :Id";
        return (Student) session.createQuery(hql)
                      .setParameter("Id", Id).uniqueResult();
    }
    
    @Transactional
    public List<student_Marks> getMarks(int stId) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM student_Marks WHERE stud_Id = :stId";
        return session.createQuery(hql)
                      .setParameter("stId", stId)
                      .list();

    }
   
}
