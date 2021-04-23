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
public class EnrollmentDAO {

        private Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public List<Enrollment> findAll() {
        return session.createQuery("from Enrollment").getResultList();
    }

    public Enrollment findById(int id) {
        return session.get(Enrollment.class, id);
    }

    public Enrollment save(Enrollment enrollment) {
        Preconditions.checkNotNull(enrollment);
        session.saveOrUpdate(enrollment);
        return enrollment;
    }

    public Enrollment update(Enrollment enrollment) {
        Preconditions.checkNotNull(enrollment);
        return (Enrollment) session.merge(enrollment);
    }

    public void delete(Enrollment enrollment) {
        Preconditions.checkNotNull(enrollment);
        session.delete(enrollment);
    }

    public void deleteById(int id) {
        final Enrollment enrollment = findById(id);
        Preconditions.checkState(enrollment != null);
        delete(enrollment);
    }
}
