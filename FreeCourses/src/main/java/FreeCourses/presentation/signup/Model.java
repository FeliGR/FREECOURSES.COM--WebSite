/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.signup;

import FreeCourses.logic.Student;
import FreeCourses.logic.User;

/**
 *
 * @author felig
 */
public class Model {
    private Student current;
    private User usuario;

    public User getUser() {
        return usuario;
    }

    public void setUser(User usuario) {
        this.usuario = usuario;
    }

    public Model() {
        this.reset();
    }

    public void reset() {
        setCurrent(new Student());
        setUser(new User());
    }

    public Student getCurrent() {
        return current;
    }

    public void setCurrent(Student current) {
        this.current = current;
    }
}
