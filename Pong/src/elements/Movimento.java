/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import elements.PontoCartesiano;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.glfwGetKey;

/**
 *
 * @author Guilherme
 */
public abstract class Movimento {

    protected PontoCartesiano posicao = new PontoCartesiano(0, 0);
    protected PontoCartesiano limitePositivo = new PontoCartesiano(0.8f, 1f);
    protected PontoCartesiano limiteNegativo = new PontoCartesiano(-0.8f, -1f);
    protected PontoCartesiano tamanho = new PontoCartesiano(0, 0);

    float velocidade;

    long tela;

    protected Movimento(long tela) {
        this.tela = tela;
    }

    void movimentarHorizontal(boolean direcao) {
        if (!limiteHorizontal(direcao)) {
            posicao.addX(direcao ? velocidade : -velocidade);
        }
    }

    void movimentarVertical(boolean direcao) {
        if (!limiteVertical(direcao)) {
            posicao.addY(direcao ? velocidade : -velocidade);
        }
    }

    public void setMovimentoVertical(int teclaCima, int teclaBaixo) {
        if (glfwGetKey(tela, teclaCima) == GLFW_TRUE) {
            movimentarVertical(true);
        } else if (glfwGetKey(tela, teclaBaixo) == GLFW_TRUE) {
            movimentarVertical(false);
        }
    }

    public void setMovimentoHorizontal(int tecla) {

    }

    protected final void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    boolean limiteHorizontal(boolean direcao) {
        if (direcao) {
            return posicao.getX() + tamanho.getX() / 2 >= limitePositivo.getX();
        } else {
            return posicao.getX() - tamanho.getX() / 2 <= limiteNegativo.getX();
        }
    }

    boolean limiteVertical(boolean direcao) {
        if (direcao) {
            return posicao.getY() + tamanho.getY() / 2 >= limitePositivo.getY();
        } else {
            return posicao.getY() - tamanho.getY() / 2 <= limiteNegativo.getY();
        }
    }
}
