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
import com.google.common.base.Preconditions;

/**
 *
 * @author joela
 */
public class StudentDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Student> findAll() {
        return session.createQuery("from Student").getResultList();
    }

    public Student findById(String id) {
        return session.get(Student.class, id);
    }

    public Student save(Student student) {
        Preconditions.checkNotNull(student);
        session.saveOrUpdate(student);
        return student;
    }

    public Student update(Student student) {
        Preconditions.checkNotNull(student);
        return (Student) session.merge(student);
    }

    public void delete(Student student) {
        Preconditions.checkNotNull(student);
        session.delete(student);
    }

    public void deleteById(String id) {
        final Student student = findById(id);
        Preconditions.checkState(student != null);
        delete(student);
    }
}
