package FreeCourses.presentation.home;

import FreeCourses.logic.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alonso
 */
public class Model {

    List<Course> courses;
    Course current;

    public Model(List<Course> courses) {
        this.courses = courses;
    }

    public Model(List<Course> courses, Course current) {
        this.courses = courses;
        this.current = current;
    }

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Course> rows = new ArrayList<>();
        current = null;
        this.setCourses(rows);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCurrent() {
        return current;
    }

    public void setCurrent(Course current) {
        this.current = current;
    }

}
