/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.data;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import FreeCourses.logic.*;

/**
 *
 * @author joela
 */
public class CourseDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<Course> findAll() {
        List<Course> coursesList;
        coursesList = session.createQuery("from Course", Course.class).list();
        return coursesList;
    }
    
    public Course findById(int id) {
        Course course;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        course = (Course) q.getSingleResult();
        return course;
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
    
    public boolean delete(int id) {
        Course course;
        session.beginTransaction();
        course = session.get(Course.class, id);
        session.delete(course);
        session.getTransaction().commit();
        return true;
    }
}
