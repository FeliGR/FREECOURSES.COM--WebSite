
import FreeCourses.data.CourseDAO;
import FreeCourses.data.HibernateUtil;
import FreeCourses.data.SectionDAO;
import FreeCourses.logic.Course;
import FreeCourses.logic.Section;
import FreeCourses.logic.Service;
import FreeCourses.logic.User;
import java.util.List;
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

        Section section1 = new Section();
        Section section2 = new Section();
//        Course course = new Course();
//        
//        course.setName("Coding Java II");
//        course.setStatus(true);
//        course.setThematic("Learn to an intermediate level of Java");

//        Course courseCreated = service.saveCourse(course);
        Course courseCreated = service.findCourseById(2);//quitar de aqui

        section1.setCourse(courseCreated);
        section1.setSchedule("Mon: 15-19");

        Course courseDB = service.findCourseById(courseCreated.getId());
        section2.setCourse(courseDB);
        section2.setSchedule("Thu: 18-22");

        service.saveSection(section1);
        service.saveSection(section2);

        System.out.println(courseDB.toString());

        Course DBCourseTwo = service.findCourseById(courseDB.getId());
        System.out.println("Course Two:" + DBCourseTwo.toString());

//        Service service = Service.instance();
//
//
//        Section courseGroup = new Section();
//        Course course = new Course();
//        Section courseGroupCreated = null;
//
//        course.setName("Progra 3");
//        course.setThematic("About Progra 3");
//        course.setStatus(true);
//
//        CourseDAO courseDAO = new CourseDAO();
//        courseDAO.save(course);
//
//        courseGroup.setCourse(course);
//        courseGroup.setSchedule("Mon - Fri");
//
//        SectionDAO sectionDAO = new SectionDAO();
//        courseGroupCreated = sectionDAO.save(courseGroup);
//        
//        
//        Course DBCourse = service.findCourseById(courseCreated.getId());
//        System.out.println("Course One:" + DBCourse.toString());
//
//        Section sectionTwo = new Section();
//        sectionTwo.setCourse(courseCreated);
//        sectionTwo.setSchedule("Thu - Sat");
//        sectionCreated = service.saveSection(sectionTwo);
//
//        Course DBCourseTwo = service.findCourseById(courseCreated.getId());
//        System.out.println("Course Two:" + DBCourseTwo.toString());
//        Course course = service.findCourseById(1);
//        System.out.print(course.toString());
    }
}
