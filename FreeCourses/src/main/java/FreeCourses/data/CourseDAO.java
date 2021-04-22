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

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public Course findById(int id) {
        return session.get(Course.class, id);
    }

    public Course save(Course course) {
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();

        return course;
    }

    public Course update(Course course) {

        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();

        return course;
    }

    @SuppressWarnings("unchecked")
    public List<Course> findAll() {
        return session.createQuery("from Course").getResultList();
    }

    public void deleteById(int id) {
        final Course course = findById(id);
        delete(course);
    }

    public void delete(Course course) {
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
    }
}
