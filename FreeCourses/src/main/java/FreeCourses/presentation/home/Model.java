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

    public Model(List<Course> courses) {
        this.courses = courses;
    }
      
    public Model(){
        this.reset();
    }
    public void reset(){       
       List<Course> rows = new ArrayList<>();
       this.setCourses(rows); 
    }   
    
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
