
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
        
        
        Service service=Service.instance();
        User userPrueba = service.findUserById("1234");
        System.out.print(userPrueba.toString());
    }
}
