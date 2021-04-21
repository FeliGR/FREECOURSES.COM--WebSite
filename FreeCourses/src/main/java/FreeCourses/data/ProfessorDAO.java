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
public class ProfessorDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Professor> findAll() {
        return session.createQuery("from Professor").getResultList();
    }

    public Professor findById(String id) {
        return session.get(Professor.class, id);
    }

    public Professor save(Professor professor) {
        Preconditions.checkNotNull(professor);
        session.saveOrUpdate(professor);
        return professor;
    }

    public Professor update(Professor professor) {
        Preconditions.checkNotNull(professor);
        return (Professor) session.merge(professor);
    }

    public void delete(Professor professor) {
        Preconditions.checkNotNull(professor);
        session.delete(professor);
    }

    public void deleteById(String id) {
        final Professor professor = findById(id);
        Preconditions.checkState(professor != null);
        delete(professor);
    }
}
