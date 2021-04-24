/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.data;
import FreeCourses.logic.Enrollment;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joela
 */
public class EnrollmentDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public Enrollment findById(int id) {
        Enrollment enrollment = (Enrollment)session.find(Enrollment.class, id);
        session.refresh(enrollment); 
        return enrollment;
    }

    public Enrollment save(Enrollment enrollment) {
        session.beginTransaction();
        session.save(enrollment);
        session.getTransaction().commit();
        session.refresh(enrollment);
        return enrollment;
    }

    public Enrollment update(Enrollment enrollment) {
        session.beginTransaction();
        session.update(enrollment);
        session.getTransaction().commit();
        session.refresh(enrollment);
        return enrollment;
    }

    @SuppressWarnings("unchecked")
    public List<Enrollment> findAll() {
        return session.createQuery("from Enrollment").getResultList();
        
    }

    public void deleteById(int id) {
        final Enrollment enrollment = findById(id);
        delete(enrollment);
    }

    public void delete(Enrollment enrollment) {
        session.beginTransaction();
        session.delete(enrollment);
        session.getTransaction().commit();
        session.refresh(enrollment);
    }
}
