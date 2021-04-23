/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.data;

import FreeCourses.data.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import FreeCourses.logic.*;

/**
 *
 * @author joela
 */
public class SectionDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public Section findById(int id) {
        return session.find(Section.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Section> findAll() {
        return session.createQuery("from Section").getResultList();
    }

    public Section save(Section section) {
        session.beginTransaction();
        session.save(section);
        session.getTransaction().commit();
        session.refresh(section);
        return section;
    }

    public Section update(Section section) {
        session.beginTransaction();
        session.update(section);
        session.getTransaction().commit();
        session.refresh(section);
        return section;
    }
    
     public void deleteById(int id) {
        final Section section = findById(id);
        delete(section);
    }
     
    public void delete(Section section) {
        session.beginTransaction();
        session.delete(section);
        session.getTransaction().commit();
        session.refresh(section);
    }
}
