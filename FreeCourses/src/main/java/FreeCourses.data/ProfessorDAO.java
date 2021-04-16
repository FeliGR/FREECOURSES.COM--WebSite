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
public class ProfessorDAO {
        private Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<Professor> findAll() {
        List<Professor> professorsList;
        professorsList = session.createQuery("from Professor", Professor.class).list();
        return professorsList;
    }
    
    public Professor findById(String id) {
        Professor professor;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Professor> query = builder.createQuery(Professor.class);
        Root<Professor> root = query.from(Professor.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        professor = (Professor) q.getSingleResult();
        return professor;
    }
    
    public Professor save(Professor professor) {
        session.beginTransaction();
        session.save(professor);
        session.getTransaction().commit();
        return professor;
    }
    
    public Professor update(Professor professor) {
        session.beginTransaction();
        session.update(professor);
        session.getTransaction().commit();
        return professor;
    }
    
    public boolean delete(String id) {
        Professor professor;
        session.beginTransaction();
        professor = session.get(Professor.class, id);
        session.delete(professor);
        session.getTransaction().commit();
        return true;
    }
}
