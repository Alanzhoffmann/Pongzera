/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.util.ArrayList;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import pong.Bola;
import pong.Pad;
import pong.Regra;

/**
 *
 * @author udesc
 */
public class Screen {

    long tela;

    int width = 800;
    int height = 480;

    GLFWErrorCallback errorCallback;
    GLFWKeyCallback keyCallback;
    GLFWFramebufferSizeCallback fsCallback;

    final Object lock = new Object();
    boolean destroyed;

    Bola bola;
    Pad padLeft;
    Pad padRight;

    public void init() {

        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));

        if (!glfwInit()) {
            throw new IllegalStateException("Falhou ao iniciar o GLFW");
        }

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        long monitor = glfwGetPrimaryMonitor();

        tela = glfwCreateWindow(width, height, "Campo", 0, 0);
        if (tela == 0) {
            throw new IllegalStateException("Falhou ao criar a tela!");
        }

        bola = new Bola(tela);
        bola.setPosicaoInicial(0, 0);

        padLeft = new Pad(tela);
        padLeft.setPosicao(-1.5f, 0);

        padRight = new Pad(tela);
        padRight.setPosicao(1.5f, 0);

        glfwSetKeyCallback(tela, keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                    glfwSetWindowShouldClose(window, true);
                }
            }
        });
        glfwSetFramebufferSizeCallback(tela, fsCallback = new GLFWFramebufferSizeCallback() {
            @Override
            public void invoke(long window, int w, int h) {
                if (w > 0 && h > 0) {
                    width = w;
                    height = h;
                }
            }
        });

        GLFWVidMode videoMode = glfwGetVideoMode(monitor); // Se colocar essa função dentro do quarto campo da glfwCreateWindow vira fullscreen
        if (videoMode != null) {
            glfwSetWindowPos(tela, ((videoMode.width() - width) / 2), ((videoMode.height() - height) / 2)); // Divisão serve para centralizar a tela;
        }
        glfwShowWindow(tela);
    }

    public void renderLoop() {
        glfwMakeContextCurrent(tela);
        GL.createCapabilities();
        glfwSwapInterval(1);

        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

//        long lastTime = System.nanoTime();
        while (!destroyed) {
            glClear(GL_COLOR_BUFFER_BIT);
            glViewport(0, 0, width, height);

//            long thisTime = System.nanoTime();
//            float elapsed = (lastTime - thisTime) / 1E9f;
//            lastTime = thisTime;
            float aspect = (float) width / height;
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(-1.0f * aspect, +1.0f * aspect, -1.0f, +1.0f, -1.0f, +1.0f);

//            glMatrixMode(GL_MODELVIEW);
//            glRotatef(elapsed * 1000.0f, 0, 0, 1);
//            glBegin(GL_QUADS);
//            glVertex2f(-0.5f, -0.5f);
//            glVertex2f(+0.5f, -0.5f);
//            glVertex2f(+0.5f, +0.5f);
//            glVertex2f(-0.5f, +0.5f);
//            glEnd();
            bola.init();
            bola.quicar();

            ArrayList<Bola> bolas = new ArrayList<>();
            bolas.add(bola);

            ArrayList<Pad> pads = new ArrayList<>();
            pads.add(padLeft);
            pads.add(padRight);

            padLeft.init();
            padRight.init();

            Regra.colisao(bolas, pads);

            padLeft.setMovimentoVertical(GLFW_KEY_W, GLFW_KEY_S);
            padRight.setMovimentoVertical(GLFW_KEY_UP, GLFW_KEY_DOWN);

            synchronized (lock) {
                if (!destroyed) {
                    glfwSwapBuffers(tela);
                }
            }
        }
    }

    public void create() {

        glfwSetInputMode(tela, GLFW_CURSOR, GLFW_CURSOR_DISABLED);

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(tela, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            }
        });
    }

    void winProcLoop() {
        /*
		 * Start new thread to have the OpenGL context current in and which does
		 * the rendering.
         */
        new Thread(() -> {
            renderLoop();
        }).start();

        while (!glfwWindowShouldClose(tela)) {
            glfwWaitEvents();
        }
    }

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        try {
            init();
            winProcLoop();

            synchronized (lock) {
                destroyed = true;
                glfwDestroyWindow(tela);
            }

            keyCallback.free();
            fsCallback.free();
        } finally {
            glfwTerminate();
            errorCallback.free();
        }
    }
}
