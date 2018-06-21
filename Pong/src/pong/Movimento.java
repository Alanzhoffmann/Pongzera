/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import elements.PontoCartesiano;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.glfwGetKey;

/**
 *
 * @author Guilherme
 */
public abstract class Movimento {

    protected PontoCartesiano posicao = new PontoCartesiano(0, 0);

    float velocidade;

    long tela;

    protected Movimento(long tela) {
        this.tela = tela;
    }

    public void setMovimentoVertical(int teclaCima, int teclaBaixo) {
        if (glfwGetKey(tela, teclaCima) == GLFW_TRUE) {
            posicao.addY(velocidade);
        } else if (glfwGetKey(tela, teclaCima) == GLFW_TRUE) {
            posicao.addY(-velocidade);
        }
    }

    public void setMovimentoHorizontal(int tecla) {

    }
}
