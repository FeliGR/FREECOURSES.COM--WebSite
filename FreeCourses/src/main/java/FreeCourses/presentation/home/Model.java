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
      
      public Model(){
        this.reset();
    }
    public void reset(){       
        setCourses(new ArrayList<Course>());
    }   
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
