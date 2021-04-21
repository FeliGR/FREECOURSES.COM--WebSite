/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.logic;

import FreeCourses.data.*;
import java.util.List;

/**
 *
 * @author felig
 */
public class Service {

    private static Service uniqueInstance;

    public static Service instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    private AdministratorDAO adminDAO;
    private CourseDAO courseDAO;
    private EnrollmentDAO enrollmentDAO;
    private SectionDAO sectionDAO;
    private ProfessorDAO professorDAO;
    private StudentDAO studentDAO;
    private UserDAO userDAO;

    public Service() {
        adminDAO = new AdministratorDAO();
        courseDAO = new CourseDAO();
        enrollmentDAO = new EnrollmentDAO();
        sectionDAO = new SectionDAO();
        professorDAO = new ProfessorDAO();
        studentDAO = new StudentDAO();
        userDAO = new UserDAO();
    }

    // <editor-fold defaultstate="collapsed" desc="Administrator C-R-U-D methods. Click on the + sign on the left to edit the code.">
    public Administrator findAdminById(String id) throws Exception {
        return adminDAO.findById(id);
    }

    public List<Administrator> findAllAdmins() throws Exception {
        return adminDAO.findAll();
    }

    public Administrator saveAdmin(Administrator admin) throws Exception {
        return adminDAO.save(admin);
    }

    public Administrator updateAdmin(Administrator admin) throws Exception {
        return adminDAO.update(admin);
    }

    public void deleteAdminById(String id) throws Exception {
        adminDAO.deleteById(id);
    }

    public void deleteAdmin(Administrator admin) throws Exception {
        adminDAO.delete(admin);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Course C-R-U-D methods. Click on the + sign on the left to edit the code.">
    public Course findCourseById(int id) throws Exception {
        Course course;
        course = courseDAO.findById(id);
        return course;
    }

    public List<Course> findAllCourses() throws Exception {
        List<Course> courseList;
        courseList = courseDAO.findAll();
        return courseList;
    }

    public Course saveCourse(Course course) throws Exception {
        return courseDAO.save(course);
    }

    public Course updateCourse(Course course) {
        return courseDAO.update(course);
    }

    public void deleteCourse(Course course) {
        courseDAO.delete(course);
    }

    public void deleteCourseById(int id) {
        courseDAO.deleteById(id);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Enrollment C-R-U-D methods. Click on the + sign on the left to edit the code.">
    public Enrollment findEnrollmentById(int id) throws Exception {
        return enrollmentDAO.findById(id);
    }

    public List<Enrollment> findAllEnrollments() throws Exception {
        return enrollmentDAO.findAll();
    }

    public Enrollment saveEnrollment(Enrollment enrollment) throws Exception {
        return enrollmentDAO.save(enrollment);
    }

    public Enrollment updateEnrollment(Enrollment enrollment) {
        return enrollmentDAO.update(enrollment);
    }

    public void deleteEnrollment(Enrollment enrollment) throws Exception {
        enrollmentDAO.delete(enrollment);
    }

    public void deleteEnrollment(int id) {
        enrollmentDAO.deleteById(id);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Section C-R-U-D methods. Click on the + sign on the left to edit the code.">
    public Section findSectionById(int id) throws Exception {
        return sectionDAO.findById(id);
    }

    public List<Section> findAllSections() throws Exception {
        return sectionDAO.findAll();
    }

    public Section saveSection(Section section) throws Exception {
        return sectionDAO.save(section);
    }

    public Section updateSection(Section section) {
        return sectionDAO.update(section);
    }

    public void deleteSection(Section section) throws Exception {
        sectionDAO.delete(section);
    }

    public void deleteSectionById(int id) throws Exception {
        sectionDAO.deleteById(id);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Professor C-R-U-D methods. Click on the + sign on the left to edit the code.">
    public Professor findProfessorById(String id) throws Exception {
        return professorDAO.findById(id);
    }

    public List<Professor> findAllProfessors() throws Exception {
        return professorDAO.findAll();
    }

    public Professor saveProfessor(Professor professor) throws Exception {
        return professorDAO.save(professor);
    }

    public Professor updateProfessor(Professor professor) throws Exception {
        return professorDAO.update(professor);
    }

    public void deleteProfessorById(String id) throws Exception {
        professorDAO.deleteById(id);
    }

    public void deleteProfessor(Professor professor) throws Exception {
        professorDAO.delete(professor);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Student C-R-U-D methods. Click on the + sign on the left to edit the code.">
    public Student findStudentById(String id) throws Exception {
        return studentDAO.findById(id);
    }

    public List<Student> findAllStudents() throws Exception {
        return studentDAO.findAll();
    }

    public Student saveStudent(Student student) throws Exception {
        return studentDAO.save(student);
    }

    public Student updateStudent(Student student, String id) throws Exception {
        return studentDAO.update(student);
    }

    public void deleteStudentById(String id) throws Exception {
        studentDAO.deleteById(id);
    }

    public void deleteStudent(Student student) throws Exception {
        studentDAO.delete(student);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="User C-R-U-D methods. Click on the + sign on the left to edit the code.">
    public User findUserById(String id) {
        return userDAO.findById(id);
    }

    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    public User saveUser(User user) {
        return userDAO.save(user);
    }

    public User updateUser(User user, String id) {
        return userDAO.update(user);
    }

    public void deleteUserById(String id) throws Exception {
        userDAO.deleteById(id);
    }

    public void deleteUser(User user) throws Exception {
        userDAO.delete(user);
    }// </editor-fold>

}
