
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
        Section section3 = new Section();
//        Course course = new Course();
//        
//        course.setName("Coding Java II");
//        course.setStatus(true);
//        course.setThematic("Learn to an intermediate level of Java");

//        Course courseCreated = service.saveCourse(course);
        Course courseCreated = service.findCourseById(6);//quitar de aqui

        section1.setCourse(courseCreated);
        section1.setSchedule("Mon: 15-19");
        courseCreated = service.findCourseById(7);//quitar de aqui

        section3.setCourse(courseCreated);
        section3.setSchedule("Wed: 15-19");

        
        section2.setCourse(courseCreated);
        section2.setSchedule("Thu: 18-22");

        service.saveSection(section1);
        service.saveSection(section2);
        service.saveSection(section3);

        System.out.println(courseCreated.toString());

        Course DBCourseTwo = service.findCourseById(courseCreated.getId());
        System.out.println("Course Two:" + DBCourseTwo.toString());
    }
}
