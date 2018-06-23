/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.glfwGetKey;

/**
 *
 * @author Guilherme
 */
public abstract class Movimento {

    protected PontoCartesiano posicao = new PontoCartesiano(0, 0);
    protected PontoCartesiano limitePositivo = new PontoCartesiano(1.6f, 1f);
    protected PontoCartesiano limiteNegativo = new PontoCartesiano(-1.6f, -1f);
    protected PontoCartesiano tamanho = new PontoCartesiano(0, 0);

    float velocidade;

    long tela;

    protected Movimento(long tela) {
        this.tela = tela;
    }

    protected void movimentarHorizontal(boolean direcao) {
        if (!limiteHorizontal(direcao)) {
            posicao.addX(direcao ? velocidade : -velocidade);
        }
    }

    protected void movimentarVertical(boolean direcao) {
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

    protected boolean limiteHorizontal(boolean direcao) {
        if (direcao) {
            return getPosicaoDireita() >= limitePositivo.getX();
        } else {
            return getPosicaoEsquerda() <= limiteNegativo.getX();
        }
    }

    protected boolean limiteVertical(boolean direcao) {
        if (direcao) {
            return getPosicaoTopo() >= limitePositivo.getY();
        } else {
            return getPosicaoBase() <= limiteNegativo.getY();
        }
    }

    public float getPosicaoTopo() {
        return posicao.getY() + tamanho.getY() / 2;
    }

    public float getPosicaoBase() {
        return posicao.getY() - tamanho.getY() / 2;
    }

    public float getPosicaoEsquerda() {
        return posicao.getX() - tamanho.getX() / 2;
    }

    public float getPosicaoDireita() {
        return posicao.getX() + tamanho.getX() / 2;
    }

    public boolean coincidente(Movimento objeto) {
        return objeto.getPosicaoBase() < getPosicaoTopo()
                && objeto.getPosicaoTopo() > getPosicaoBase()
                && objeto.getPosicaoEsquerda() < getPosicaoDireita()
                && objeto.getPosicaoDireita() > getPosicaoEsquerda();
    }

    public float getPosicaoX() {
        return posicao.getX();
    }

    public float getPosicaoY() {
        return posicao.getY();
    }
}
