
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
//        Section section;
//        Section sectionUpdated;
//        int idEntity = 1;
//
//        section = service.findSectionById(idEntity);
//        section.setSchedule("Thu");
//        service.updateSection(section);
//        sectionUpdated = service.findSectionById(idEntity);

        Section section = new Section();
        Course course = new Course();
        Section sectionCreated = null;

        course.setName("Progra 4");
        course.setThematic("About Progra 4");
        course.setStatus(true);

        Course courseCreated = service.saveCourse(course);

        section.setCourse(course);
        section.setSchedule("Wed - Fri");

        sectionCreated = service.saveSection(section);

        Course DBCourse = service.findCourseById(courseCreated.getId());
        System.out.print(DBCourse.toString());

//        Course course = service.findCourseById(1);
//        System.out.print(course.toString());
    }
}
