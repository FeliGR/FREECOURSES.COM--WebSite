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
public class SectionDAO {

    private final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public Section findById(int id) {
        return session.get(Section.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Section> findAll() {
        return session.createQuery("from Section").getResultList();
    }

    public Section save(Section section) {
        session.beginTransaction();
        session.save(section);
        session.getTransaction().commit();
        

        return section;
    }

    public Section update(Section section) {
        session.beginTransaction();
        session.update(section);
        session.getTransaction().commit();

        return section;
    }

    public void delete(Section section) {
        session.beginTransaction();
        session.delete(section);
        session.getTransaction().commit();
    }

    public void deleteById(int id) {
        final Section section = findById(id);
        delete(section);
    }
}
