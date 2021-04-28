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
public class StudentDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public Student findById(String id) {
        session.clear();
        Student student = (Student) session.find(Student.class, id);
        session.refresh(student);
        return student;
    }

    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        session.clear();
        return session.createQuery("from Student").getResultList();
    }

    public Student save(Student student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.refresh(student);
        return student;
    }

    public Student update(Student student) {
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.refresh(student);
        return student;
    }

    public void deleteById(String id) {
        final Student student = findById(id);
        delete(student);
    }

    public void delete(Student student) {
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.refresh(student);
    }
}
