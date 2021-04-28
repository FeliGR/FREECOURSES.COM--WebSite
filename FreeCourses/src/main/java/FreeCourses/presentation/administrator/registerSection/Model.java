/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.presentation.administrator.registerSection;

import FreeCourses.logic.Section;

/**
 * @author alonso
 * @author felig
 * @author joela
 */
public class Model {
    private Section current;

    public Model() {
        this.reset();
    }

    public void reset() {
        setCurrent(new Section());
    }

    public Section getCurrent() {
        return current;
    }

    public void setCurrent(Section current) {
        this.current = current;
    }
}
