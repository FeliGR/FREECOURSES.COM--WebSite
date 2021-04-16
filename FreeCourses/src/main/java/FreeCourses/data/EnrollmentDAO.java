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
public class EnrollmentDAO {
        private Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<Enrollment> findAll() {
        List<Enrollment> enrollmentsList;
        enrollmentsList = session.createQuery("from Enrollment", Enrollment.class).list();
        return enrollmentsList;
    }
    
    public Enrollment findById(int id) {
        Enrollment enrollment;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Enrollment> query = builder.createQuery(Enrollment.class);
        Root<Enrollment> root = query.from(Enrollment.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        enrollment = (Enrollment) q.getSingleResult();
        return enrollment;
    }
    
    public Enrollment save(Enrollment enrollment) {
        session.beginTransaction();
        session.save(enrollment);
        session.getTransaction().commit();
        return enrollment;
    }
    
    public Enrollment update(Enrollment enrollment) {
        session.beginTransaction();
        session.update(enrollment);
        session.getTransaction().commit();
        return enrollment;
    }
    
    public boolean delete(int id) {
        Enrollment enrollment;
        session.beginTransaction();
        enrollment = session.get(Enrollment.class, id);
        session.delete(enrollment);
        session.getTransaction().commit();
        return true;
    }
}
