
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

//        Service service = Service.instance();
//        Course course = new Course("History","Learn History", true);
//        
//        Course courseDB = service.findCourseById(service.saveCourse(course).getId());
//      
//        Section section=new Section("ABCD","Monday - Friday");
//        service.saveSection(section);
//        courseDB.getGroupsList().add(section);
//        service.updateCourse(courseDB, courseDB.getId());
//        Course course = new Course("Progra 3", "programando3", true);
//        Section section = new Section("AAAA", "Monday - Friday");
//        Section section2 = new Section("Hola Mundo", "Saturday-Sunday");
//        service.saveSection(section);
//        service.saveSection(section2);
//        course.getGroupsList().add(section);
//        course.getGroupsList().add(section2);
//        
//        Course courseSaved = service.saveCourse(course);
//        
//        Course DBCourse = service.findCourseById(courseSaved.getId());
//
//        service.deleteCourse(courseSaved.getId());
//        
//        Section section3 = new Section(DBCourse.getName(), "Saturday-Sunday");
//        service.saveSection(DBCourse.getGroupsList().get(0));
//        service.saveSection(DBCourse.getGroupsList().get(1));
//        service.saveSection(section3);
//        DBCourse.getGroupsList().add(section3);
//        courseSaved = service.saveCourse(DBCourse);
        Service service = Service.instance();

        Course course = new Course("History", "Learn History", true);
        Section section = new Section("Monday - Friday");
        service.saveSection(section);
        course.getGroupsList().add(section);
        service.saveCourse(course);
//        
//        Course courseUpdate=service.findCourseById(course.getId());
//        
//        service.updateCourse(courseUpdate, courseUpdate.getId());
    }
}
