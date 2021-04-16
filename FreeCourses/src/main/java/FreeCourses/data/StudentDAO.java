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
public class StudentDAO {
        private Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<Student> findAll() {
        List<Student> studentsList;
        studentsList = session.createQuery("from Student", Student.class).list();
        return studentsList;
    }
    
    public Student findById(String id) {
        Student student;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        student = (Student) q.getSingleResult();
        return student;
    }
    
    public Student save(Student student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        return student;
    }
    
    public Student update(Student student) {
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        return student;
    }
    
    public boolean delete(String id) {
        Student student;
        session.beginTransaction();
        student = session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
        return true;
    }
}
