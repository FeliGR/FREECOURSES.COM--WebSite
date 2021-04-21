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

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Section> findAll() {
        return session.createQuery("from Section").getResultList();
    }

    public Section findById(int id) {
        return session.get(Section.class, id);
    }

    public Section save(Section section) {
        Preconditions.checkNotNull(section);
        session.saveOrUpdate(section);
        return section;
    }

    public Section update(Section section) {
        Preconditions.checkNotNull(section);
        return (Section) session.merge(section);
    }

    public void delete(Section section) {
        Preconditions.checkNotNull(section);
        session.delete(section);
    }

    public void deleteById(int id) {
        final Section section = findById(id);
        Preconditions.checkState(section != null);
        delete(section);
    }
}
