/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.data;
import java.util.List;
import org.hibernate.Session;
import FreeCourses.logic.*;

/**
 *
 * @author joela
 */
public class CourseDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Course findById(int id) {
        session.clear();
        Course course = (Course)session.find(Course.class, id);
        session.refresh(course); 
        return course;
    }

    public Course save(Course course) {
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.refresh(course);
        return course;
    }

    public Course update(Course course) {
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
        session.refresh(course);
        return course;
    }

    @SuppressWarnings("unchecked")
    public List<Course> findAll() {
        session.clear();
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
        session.refresh(course);
    }
}
