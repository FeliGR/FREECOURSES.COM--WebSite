/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.data;

import java.util.List;
import org.hibernate.Session;
import FreeCourses.logic.*;
import com.google.common.base.Preconditions;

/**
 *
 * @author joela
 */
public class CourseDAO {

    private Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public void validateSession() {
        if (!session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
    }

    public Course findById(int id) {
        validateSession();
        return session.get(Course.class, id);
    }

    public Course save(Course course) {
        validateSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();

        return course;
    }

    public Course update(Course course) {
        validateSession();
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();

        return course;
    }

    @SuppressWarnings("unchecked")
    public List<Course> findAll() {
        validateSession();
        return session.createQuery("from Course").getResultList();
    }

    public void deleteById(int id) {
        validateSession();
        final Course course = findById(id);
        delete(course);
    }

    public void delete(Course course) {
        validateSession();
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
    }
}
