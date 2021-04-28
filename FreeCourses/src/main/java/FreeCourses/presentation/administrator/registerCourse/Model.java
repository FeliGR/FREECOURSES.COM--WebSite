/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.registerCourse;

import FreeCourses.logic.Course;
import FreeCourses.logic.Student;
import FreeCourses.logic.User;

/**
 * @author alonso
 * @author felig
 * @author joela
 */
public class Model {
    private Course current;

    public Model() {
        this.reset();
    }

    public void reset() {
        setCurrent(new Course());
    }

    public Course getCurrent() {
        return current;
    }

    public void setCurrent(Course current) {
        this.current = current;
    }
}
