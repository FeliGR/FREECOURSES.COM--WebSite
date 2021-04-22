
import FreeCourses.logic.Course;
import FreeCourses.logic.Section;
import FreeCourses.logic.Service;
import FreeCourses.logic.User;

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

//        Course course = new Course("History", "Learn History", true);
//        Section section = new Section ("Monday - Friday");
//        section.setCourse(course);
//        service.saveCourse(course);
//        service.saveSection(section);

        Course course = service.findCourseById(1);
        System.out.print(course.toString());
        
    }
}
