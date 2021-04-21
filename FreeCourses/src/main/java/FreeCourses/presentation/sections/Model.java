/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.sections;

import FreeCourses.logic.Course;
import FreeCourses.logic.Section;
import java.util.List;

/**
 * 
 * @author joela
 * @author felig
 */
public class Model {
//    List<Section> sectionsList;
    Course course;
    Section current;

    public Model() {
    }

//    public Model(List<Section> sectionsList) {
//        this.sectionsList = sectionsList;
//    }

    public Model(Course course, Section current) {
        //this.sectionsList = sectionsList;
        this.course = course;
        this.current = current;
    }

//    public List<Section> getSectionsList() {
//        return sectionsList;
//    }
//
//    public void setSectionsList(List<Section> sectionsList) {
//        this.sectionsList = sectionsList;
//    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Section getCurrent() {
        return current;
    }

    public void setCurrent(Section current) {
        this.current = current;
    }
}