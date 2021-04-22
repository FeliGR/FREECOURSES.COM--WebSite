
import FreeCourses.logic.Course;
import FreeCourses.logic.Section;
import FreeCourses.logic.Service;
import FreeCourses.logic.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felig
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Service service = Service.instance();
        Section section;
        Section sectionUpdated;
        int idEntity = 1;

        section = service.findSectionById(idEntity);
        section.setSchedule("Thu");
        service.updateSection(section);
        sectionUpdated = service.findSectionById(idEntity);
    }
}
