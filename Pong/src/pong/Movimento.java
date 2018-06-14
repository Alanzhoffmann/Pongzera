/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import org.lwjgl.glfw.GLFWKeyCallback;

/**
 *
 * @author Guilherme
 */
public class Movimento extends GLFWKeyCallback {
    float x;
    float y;
    float velocidade;

    public void movimentar(float x, float y) {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            y += 1;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            y -= 1;
        }
    }
}
