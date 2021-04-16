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

    public Administrator findAdminById(String id) throws Exception {
        Administrator administrator;
        administrator = adminDAO.findById(id);
        return administrator;
    }

    public Course findCourseById(int id) throws Exception {
        Course course;
        course = courseDAO.findById(id);
        return course;
    }

    public Enrollment findEnrollmentById(int id) throws Exception {
        Enrollment enrollment;
        enrollment = enrollmentDAO.findById(id);
        return enrollment;
    }

    public Section findSectionById(int id) throws Exception {
        Section section;
        section = sectionDAO.findById(id);
        return section;
    }

    public Professor findProfessorById(String id) throws Exception {
        Professor professor;
        professor = professorDAO.findById(id);
        return professor;
    }

    public Student findStudentById(String id) throws Exception {
        Student student;
        student = studentDAO.findById(id);
        return student;
    }

    public User findUserById(String id) throws Exception {
        User user;
        user = userDAO.findById(id);
        return user;
    }

    public List<Administrator> findAllAdmins() throws Exception {
        List<Administrator> adminsList;
        adminsList = adminDAO.findAll();
        return adminsList;
    }

    public List<Course> findAllCourses() throws Exception {
        List<Course> courseList;
        courseList = courseDAO.findAll();
        return courseList;
    }

    public List<Enrollment> findAllEnrollments() throws Exception {
        List<Enrollment> enrollmentsList;
        enrollmentsList = enrollmentDAO.findAll();
        return enrollmentsList;
    }

    public List<Section> findAllSections() throws Exception {
        List<Section> sectionsList;
        sectionsList = sectionDAO.findAll();
        return sectionsList;
    }

    public List<Professor> findAllProfessors() throws Exception {
        List<Professor> professorsList;
        professorsList = professorDAO.findAll();
        return professorsList;
    }

    public List<Student> findAllStudents() throws Exception {
        List<Student> studentsList;
        studentsList = studentDAO.findAll();
        return studentsList;
    }

    public List<User> findAllUsers() throws Exception {
        List<User> usersList;
        usersList = userDAO.findAll();
        return usersList;
    }

    //Save
    public Administrator saveAdmin(Administrator admin) throws Exception {
        Administrator adminSaved;
        adminSaved = adminDAO.save(admin);
        return adminSaved;
    }

    public Course saveCourse(Course course) throws Exception {
        Course courseSaved;
        courseSaved = courseDAO.save(course);
        return courseSaved;
    }

    public Enrollment saveEnrollment(Enrollment enrollment) throws Exception {
        Enrollment enrollmentSaved;
        enrollmentSaved = enrollmentDAO.save(enrollment);
        return enrollmentSaved;
    }

    public Section saveSection(Section section) throws Exception {
        Section sectionSaved;
        sectionSaved = sectionDAO.save(section);
        return sectionSaved;
    }

    public Professor saveProfessor(Professor professor) throws Exception {
        Professor professorSaved;
        professorSaved = professorDAO.save(professor);
        return professorSaved;
    }

    public Student saveStudent(Student student) throws Exception {
        Student studentSaved;
        studentSaved = studentDAO.save(student);
        return studentSaved;
    }

    public User saveUser(User user) throws Exception {
        User userSaved;
        userSaved = userDAO.save(user);
        return userSaved;
    }

    public Administrator updateAdmin(Administrator admin, String id) throws Exception {
        Administrator adminUpdated;
        Administrator updatedAdmin = adminDAO.findById(id);
        updatedAdmin.setName(admin.getName());
        if (admin.getPassword() != null) {
            updatedAdmin.setPassword(admin.password);
        }

        adminUpdated = adminDAO.update(updatedAdmin);
        return adminUpdated;
    }

    public Course updateCourse(Course course, int id) throws Exception {
        Course courseUpdated;
        Course updatedCourse = courseDAO.findById(id);
        updatedCourse.getGroupsList().clear();//Revisar esto en caso de no servir
        updatedCourse.getGroupsList().addAll(course.getGroupsList());
        updatedCourse.setName(course.getName());
        updatedCourse.setStatus(course.isStatus());
        updatedCourse.setThematic(course.getThematic());

        courseUpdated = courseDAO.update(updatedCourse);
        return courseUpdated;
    }

    public Enrollment updateEnrollment(Enrollment enrollment, int id) throws Exception {
        Enrollment enrollmentUpdated;
        Enrollment updatedEnrollment = enrollmentDAO.findById(id);
        updatedEnrollment.setGrade(enrollment.getGrade());

        enrollmentUpdated = enrollmentDAO.update(updatedEnrollment);
        return enrollmentUpdated;
    }

    public Section updateSection(Section section, int id) throws Exception {
        Section sectionUpdated;
        Section updatedGroup = sectionDAO.findById(id);
        updatedGroup.setCourseName(section.getCourseName());
        updatedGroup.setSchedule(section.getSchedule());
        updatedGroup.getEnrollmentsList().clear();
        updatedGroup.getEnrollmentsList().addAll(section.getEnrollmentsList());

        sectionUpdated = sectionDAO.update(updatedGroup);
        return sectionUpdated;
    }
    
    public Professor updateProfessor(Professor professor, String id) throws Exception {
        Professor professorUpdated;
        Professor updatedProfessor = professorDAO.findById(id);
        updatedProfessor.setName(professor.getName());
        if (professor.getPassword() != null) {
            updatedProfessor.setPassword(professor.password);
        }
        updatedProfessor.setEmail(professor.getEmail());
        updatedProfessor.setPhone(professor.getPhone());
        updatedProfessor.setSpecialty(professor.getSpecialty());
        updatedProfessor.getGroupsList().clear();
        updatedProfessor.getGroupsList().addAll(professor.getGroupsList());

        professorUpdated = professorDAO.update(updatedProfessor);
        return professorUpdated;
    }

    public Student updateStudent(Student student, String id) throws Exception {
        Student studentUpdated;
        Student updatedStudent = studentDAO.findById(id);
        updatedStudent.setName(student.getName());
        if (student.getPassword() != null) {
            updatedStudent.setPassword(student.password);
        }
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setPhone(student.getPhone());
        updatedStudent.getEnrollmentsList().clear();//Revisar esto en caso de no servir
        updatedStudent.getEnrollmentsList().addAll(student.getEnrollmentsList());

        studentUpdated = studentDAO.update(updatedStudent);
        return studentUpdated;
    }

    public User updateUser(User user, String id) throws Exception {
        User userUpdated;
        User updatedUser = userDAO.findById(id);
        updatedUser.setType(user.getType());
        if (user.getPassword() != null) {
            updatedUser.setPassword(user.password);
        }
        userUpdated = userDAO.update(updatedUser);
        return userUpdated;
    }

    //delete
    public boolean deleteAdmin(String id) throws Exception {
        return adminDAO.delete(id);
    }

    public boolean deleteCourse(int id) throws Exception {
        return courseDAO.delete(id);
    }

    public boolean deleteEnrollment(int id) throws Exception {
        return enrollmentDAO.delete(id);
    }

    public boolean deleteSection(int id) throws Exception {
        return sectionDAO.delete(id);
    }

    public boolean deleteProfessor(String id) throws Exception {
        return professorDAO.delete(id);
    }

    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    public boolean deleteUser(String id) throws Exception {
        return userDAO.delete(id);
    }

}
