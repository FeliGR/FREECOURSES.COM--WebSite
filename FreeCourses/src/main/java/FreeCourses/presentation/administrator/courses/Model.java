/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.courses;

import FreeCourses.logic.Course;
import FreeCourses.logic.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alonso
 */
public class Model {
    private List<Course> courses;
    private Course current;
    public Model() {
        this.reset();
    }

    public Model(List<Course> courses, Professor current) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public Model(List<Course> courses) {
        this.courses = courses;
    }

    private void reset() {
        List<Course> rows = new ArrayList<>();
        this.setCourses(rows);
        current = new Course();
    }

    public void setCurrent(Course current) {
        this.current = current;
    }

    public Course getCurrent() {
        return current;
    }
}
   