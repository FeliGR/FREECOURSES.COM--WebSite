/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.student.history;

import FreeCourses.logic.Student;

/**
 *
 * @author joela
 */
public class Model {

    private Student current;

    public Model(Student current) {
        this.current = current;
    }

    public void setCurrent(Student current) {
        this.current = current;
    }

    public Student getCurrent() {
        return current;
    }

    public Model() {
    }

    @Override
    public String toString() {
        return "Model{" + "current=" + current + '}';
    }
}
