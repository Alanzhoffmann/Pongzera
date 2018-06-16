/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import elements.Box2D;
import elements.Entity2D;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.glfw.GLFWVidMode;

/**
 *
 * @author Guilherme
 */
public class Campo {

    int altura = 640;
    int largura = 640;
    float angulo;

    public void telaCampo() {
        if (!glfwInit()) {
            throw new IllegalStateException("Falhou ao iniciar o GLFW!");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        long tela = glfwCreateWindow(altura, largura, "Campo", 0, 0);
        if (tela == 0) {
            throw new IllegalStateException("Falhou ao criar a tela!");
        }

        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor()); // Se colocar essa função dentro do quarto campo da glfwCreateWindow vira fullscreen
        glfwSetWindowPos(tela, ((videoMode.width() - altura) / 2), ((videoMode.height() - largura) / 2)); // Divisão serve para centralizar a tela

        glfwShowWindow(tela);

        glfwMakeContextCurrent(tela); //Cria um contexto para a função createCapabilities

        GL.createCapabilities();

        // Antes do loop
        Entity2D box = new Box2D(0.2f, 0.2f, 1f);
        box.setUp();

        while (!glfwWindowShouldClose(tela)) {
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);
            
            box.draw(); //Dentro do loop

//            glBegin(GL_QUADS); //Cria o quadrado branco no meio da tela
//            glVertex2f(-0.5f, 0.5f);
//            glVertex2f(0.5f, 0.5f);
//            glVertex2f(0.5f, -0.5f);
//            glVertex2f(-0.5f, -0.5f);
//            glEnd();

            glfwSwapBuffers(tela); // Melhora a tela com os dois contextos back e front
        }
        box.destroy(); //Depois do loop

        glfwTerminate();
    }
}
