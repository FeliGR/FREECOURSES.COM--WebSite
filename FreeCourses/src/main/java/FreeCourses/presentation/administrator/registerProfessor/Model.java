/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.registerProfessor;

import FreeCourses.logic.Professor;
import FreeCourses.logic.User;

/**
 *
 * @author alonso
 */
public class Model {
    private Professor current;
    private User user;
    
        public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Model() {
        this.reset();
    }

    public void reset() {
        setCurrent(new Professor());
        setUser(new User());
    }

    public Professor getCurrent() {
        return current;
    }

    public void setCurrent(Professor current) {
        this.current = current;
    }
}
