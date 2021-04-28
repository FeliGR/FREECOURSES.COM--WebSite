/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.data;

import FreeCourses.logic.Professor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joela
 */
public class ProfessorDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public Professor findById(String id) {
        session.clear();
        Professor professor = (Professor) session.find(Professor.class, id);
        session.refresh(professor);
        return professor;
    }

    @SuppressWarnings("unchecked")
    public List<Professor> findAll() {
        session.clear();
        return session.createQuery("from Professor").getResultList();
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

    public void deleteById(String id) {
        final Professor professor = findById(id);
        delete(professor);
    }

    public void delete(Professor professor) {
        session.beginTransaction();
        session.delete(professor);
        session.getTransaction().commit();
    }
}
