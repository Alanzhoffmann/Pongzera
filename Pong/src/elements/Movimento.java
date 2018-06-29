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

    public void setMovimentoHorizontal(int teclaEsquerda, int teclaDireita) {
        if (glfwGetKey(tela, teclaEsquerda) == GLFW_TRUE) {
            movimentarHorizontal(false);
        } else if (glfwGetKey(tela, teclaDireita) == GLFW_TRUE) {
            movimentarHorizontal(true);
        }
    }

    protected final void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    protected final float getVelocidade() {
        return velocidade;
    }

    protected boolean limiteHorizontal(boolean direcao) {
        if (direcao) {
            return getLimiteDireito() >= limitePositivo.getX();
        } else {
            return getLimiteEsquerdo() <= limiteNegativo.getX();
        }
    }

    protected boolean limiteVertical(boolean direcao) {
        if (direcao) {
            return getLimiteTopo() >= limitePositivo.getY();
        } else {
            return getLimiteBase() <= limiteNegativo.getY();
        }
    }

    public float getLimiteTopo() {
        return posicao.getY() + tamanho.getY() / 2;
    }

    public float getLimiteBase() {
        return posicao.getY() - tamanho.getY() / 2;
    }

    public float getLimiteEsquerdo() {
        return posicao.getX() - tamanho.getX() / 2;
    }

    public float getLimiteDireito() {
        return posicao.getX() + tamanho.getX() / 2;
    }

    public boolean coincidente(Movimento objeto) {
        return objeto.getLimiteBase() < getLimiteTopo()
                && objeto.getLimiteTopo() > getLimiteBase()
                && objeto.getLimiteEsquerdo() < getLimiteDireito()
                && objeto.getLimiteDireito() > getLimiteEsquerdo();
    }

    public float getPosicaoX() {
        return posicao.getX();
    }

    public float getPosicaoY() {
        return posicao.getY();
    }

    public float getTamanhoX() {
        return tamanho.getX();
    }

    public float getTamanhoY() {
        return tamanho.getY();
    }

}
