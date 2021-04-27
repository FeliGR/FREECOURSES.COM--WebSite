/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.student.enrollment;

import FreeCourses.logic.*;

/**
 *
 * @author joela
 */
public class Model {
    private Student student;
    private Section section;
    private Enrollment enrollment;

    public Model(Student student, Section section, Enrollment enrollment) {
        this.student = student;
        this.section = section;
        this.enrollment = enrollment;
    }

    public Model() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public String toString() {
        return "Model{" + "student=" + student + ", section=" + section + ", enrollment=" + enrollment + '}';
    }
}
