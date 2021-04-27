/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.professor.sections;

import FreeCourses.logic.Professor;

/**
 *
 * @author felig
 */
public class Model {
    private Professor current;

    public Model() {
    }

    public Model(Professor current) {
        this.current = current;
    }

    public Professor getCurrent() {
        return current;
    }

    public void setCurrent(Professor current) {
        this.current = current;
    } 
}
