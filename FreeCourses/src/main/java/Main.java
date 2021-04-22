
import FreeCourses.data.HibernateUtil;
import FreeCourses.logic.Course;
import FreeCourses.logic.Section;
import FreeCourses.logic.Service;
import FreeCourses.logic.User;
import org.hibernate.SessionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felig
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Service service = Service.instance();
        Section section = new Section();
        Course course = new Course();
        Section sectionCreated = null;
 
        course.setName("Progra 3");
        course.setThematic("About Progra 3");
        course.setStatus(true);

        
        service.saveCourse(course);

        section.setCourse(course);
        section.setSchedule("Mon - Fri");

        sectionCreated = service.saveSection(section);
//        
//        System.out.print(course.toString());
//        
//        Section section;
//        Section sectionUpdated;
//        int idEntity = 1;
//
//        section = service.findSectionById(idEntity);
//        section.setSchedule("Thu");
//        service.updateSection(section);
//        sectionUpdated = service.findSectionById(idEntity);

//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        System.out.println("Session Factory : " + sessionFactory.hashCode());
//        SessionFactory sessionFactory2 = HibernateUtil.getSessionFactory();
//        System.out.println("Session Factory 2 : " + sessionFactory2.hashCode());
//        SessionFactory sessionFactory3 = HibernateUtil.getSessionFactory();
//        System.out.println("Session Factory 3 : " + sessionFactory3.hashCode());
    }
}
