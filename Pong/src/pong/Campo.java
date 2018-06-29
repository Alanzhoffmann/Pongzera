/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author Guilherme
 */
public class Campo {

//    int altura = 640;
//    int largura = 480;
    float angulo;
    float y1 = 0.0f;
    float y2 = 0.0f;

    private static final GLFWFramebufferSizeCallback resizeWindow = new GLFWFramebufferSizeCallback() {
        @Override
        public void invoke(long window, int width, int height) {
            GL11.glViewport(0, 0, width, height);
            float aspect = (float) width / height;
            GL11.glLoadIdentity();
            GL11.glScalef(1.0f / aspect, 1, 1);
            //update any other window vars you might have (aspect ratio, MVP matrices, etc)
        }
    };

    public void telaCampo() {
        if (!glfwInit()) {
            throw new IllegalStateException("Falhou ao iniciar o GLFW!");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode videoMode = glfwGetVideoMode(monitor); // Se colocar essa função dentro do quarto campo da glfwCreateWindow vira fullscreen

        long tela = glfwCreateWindow(640, 480, "Campo", 0, 0);

        if (tela == 0) {
            throw new IllegalStateException("Falhou ao criar a tela!");
        }

//        glfwSetWindowPos(tela, ((videoMode.width() - altura) / 2), ((videoMode.height() - largura) / 2)); // Divisão serve para centralizar a tela;
        glfwShowWindow(tela);

        glfwMakeContextCurrent(tela); //Cria um contexto para a função createCapabilities

        GL.createCapabilities();

        Bola bola = new Bola(tela);
        bola.setPosicao(0, 0);
        bola.setTamanho(0.05f, 0.05f);

        GLFW.glfwSetFramebufferSizeCallback(tela, resizeWindow);

        while (!glfwWindowShouldClose(tela)) {
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);

//            glBegin(GL_QUADS); //Cria o pad da direita
//            glVertex2f(0.9f, 0.4f + y1);
//            glVertex2f(0.95f, 0.4f + y1);
//            glVertex2f(0.95f, 0.2f + y1);
//            glVertex2f(0.9f, 0.2f + y1);
//            glEnd();
//
//            glBegin(GL_QUADS); //Cria o pad da esquerda
//            glVertex2f(-0.9f, 0.4f + y2);
//            glVertex2f(-0.95f, 0.4f + y2);
//            glVertex2f(-0.95f, 0.2f + y2);
//            glVertex2f(-0.9f, 0.2f + y2);
//            glEnd();
            bola.init();

            bola.setMovimentoVertical(GLFW_KEY_UP, GLFW_KEY_DOWN);

            glfwSwapBuffers(tela); // Melhora a tela com os dois contextos back e front
        }

        glfwTerminate();
    }
}
