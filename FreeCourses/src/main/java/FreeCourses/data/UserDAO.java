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
public class UserDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public List<User> findAll() {
        return session.createQuery("from User").getResultList();
    }

    public User findById(String id) {
        return session.get(User.class, id);
    }

    public User save(User user) {
        Preconditions.checkNotNull(user);
        session.saveOrUpdate(user);
        return user;
    }

    public User update(User user) {
        Preconditions.checkNotNull(user);
        return (User) session.merge(user);
    }

    public void delete(User user) {
        Preconditions.checkNotNull(user);
        session.delete(user);
    }

    public void deleteById(String id) {
        final User user = findById(id);
        Preconditions.checkState(user != null);
        delete(user);
    }
}
