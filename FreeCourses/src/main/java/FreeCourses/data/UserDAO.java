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
public class UserDAO {
        private Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<User> findAll() {
        List<User> usersList;
        usersList = session.createQuery("from User", User.class).list();
        return usersList;
    }
    
    public User findById(String id) {
        User user;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        user = (User) q.getSingleResult();
        return user;
    }
    
    public User save(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }
    
    public User update(User user) {
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        return user;
    }
    
    public boolean delete(String id) {
        User user;
        session.beginTransaction();
        user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        return true;
    }
}
