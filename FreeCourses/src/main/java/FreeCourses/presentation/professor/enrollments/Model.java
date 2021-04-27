/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.professor.enrollments;

import FreeCourses.logic.Enrollment;
import FreeCourses.logic.Professor;
import FreeCourses.logic.Section;

/**
 *
 * @author felig
 */
public class Model {
    private Professor professor;
    private Section section;
    private Enrollment current;

    public Model() {
    }

    public Model(Professor professor, Section section, Enrollment current) {
        this.professor = professor;
        this.section = section;
        this.current = current;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Enrollment getEnrollment() {
        return current;
    }

    public void setEnrollment(Enrollment current) {
        this.current = current;
    }
}
