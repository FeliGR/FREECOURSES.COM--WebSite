/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses;


import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author joela
 */
public class SectionDAO {
        private Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<Section> findAll() {
        List<Section> sectionsList;
        sectionsList = session.createQuery("from Group", Section.class).list();
        return sectionsList;
    }
    
    public Section findById(int id) {
        Section section;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Section> query = builder.createQuery(Section.class);
        Root<Section> root = query.from(Section.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        section = (Section) q.getSingleResult();
        return section;
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
    
    public boolean delete(int id) {
        Section section;
        session.beginTransaction();
        section = session.get(Section.class, id);
        session.delete(section);
        session.getTransaction().commit();
        return true;
    }
}
