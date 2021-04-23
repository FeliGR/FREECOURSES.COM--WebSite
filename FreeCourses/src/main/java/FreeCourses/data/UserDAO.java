/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.data;
import FreeCourses.data.HibernateUtil;
import FreeCourses.logic.User;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joela
 */
public class UserDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public User findById(String id) {
        return session.find(User.class, id);
    }

    public User save(User course) {
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.refresh(course);
        return course;
    }

    public User update(User course) {
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
        session.refresh(course);
        return course;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return session.createQuery("from User").getResultList();
    }

    public void deleteById(String id) {
        final User course = findById(id);
        delete(course);
    }

    public void delete(User course) {
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
        session.refresh(course);
    }
}
