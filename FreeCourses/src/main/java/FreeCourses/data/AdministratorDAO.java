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
  @author joela
 */
public class AdministratorDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<Administrator> findAll() {
        List<Administrator> administratorsList;
        administratorsList = session.createQuery("from Administrator", Administrator.class).list();
        return administratorsList;
    }
    
    public Administrator findById(String id) {
        Administrator administrator;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Administrator> query = builder.createQuery(Administrator.class);
        Root<Administrator> root = query.from(Administrator.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        administrator = (Administrator) q.getSingleResult();
        return administrator;
    }
    
    public Administrator save(Administrator administrator) {
        session.beginTransaction();
        session.save(administrator);
        session.getTransaction().commit();
        return administrator;
    }
    
    public Administrator update(Administrator administrator) {
        session.beginTransaction();
        session.update(administrator);
        session.getTransaction().commit();
        return administrator;
    }
    
    public boolean delete(String id) {
        Administrator administrator;
        session.beginTransaction();
        administrator = session.get(Administrator.class, id);
        session.delete(administrator);
        session.getTransaction().commit();
        return true;
    }
}
