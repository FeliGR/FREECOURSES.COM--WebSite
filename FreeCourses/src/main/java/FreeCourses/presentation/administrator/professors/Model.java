/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.professors;

import FreeCourses.logic.Course;
import FreeCourses.logic.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alonso
 */
public class Model {
    private List<Professor> professors;
    
    public Model() {
        this.reset();
    }

    public Model(List<Professor> professors, Professor current) {
        this.professors = professors;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
    public Model(List<Professor> professors) {
        this.professors = professors;
    }

    private void reset() {
        List<Professor> rows = new ArrayList<>();
        this.setProfessors(rows);
    }
}
    
    
    
    

