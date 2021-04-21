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
 * @author joela
 */
public class AdministratorDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Administrator> findAll() {
        return session.createQuery("from Administrator").getResultList();
    }

    public Administrator findById(String id) {
        return session.get(Administrator.class, id);
    }

    public Administrator save(Administrator administrator) {
        Preconditions.checkNotNull(administrator);
        session.saveOrUpdate(administrator);
        return administrator;
    }

    public Administrator update(Administrator administrator) {
        Preconditions.checkNotNull(administrator);
        return (Administrator) session.merge(administrator);
    }

    public void deleteById(String id) {
        final Administrator administrator = findById(id);
        Preconditions.checkState(administrator != null);
        delete(administrator);
    }

    public void delete(Administrator administrator) {
        Preconditions.checkNotNull(administrator);
        session.delete(administrator);
    }
}
