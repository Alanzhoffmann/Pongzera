/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import elements.Box2D;
import elements.Entity2D;
import elements.Screen;

/**
 *
 * @author Guilherme
 */
public class Pong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Screen screen = new Screen();
//        screen.run();
        Campo campo = new Campo();
        campo.telaCampo();
    }
    
}
