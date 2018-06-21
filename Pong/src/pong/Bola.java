/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import elements.PontoCartesiano;
import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

/**
 *
 * @author Guilherme
 */
public class Bola extends Movimento {

    public Bola(long tela) {
        super(tela);
        velocidade = 0.1f;
    }

    private final PontoCartesiano tamanho = new PontoCartesiano(0, 0);

    public void setPosicao(float x, float y) {
        posicao.setX(x);
        posicao.setY(y);
    }

    public void setTamanho(float x, float y) {
        tamanho.setX(x);
        tamanho.setY(y);
    }

    public void init() {
        glBegin(GL_QUADS); //Cria a "bola"

        ArrayList<PontoCartesiano> pontos = new ArrayList<>();
        pontos.add(new PontoCartesiano((posicao.getX() - tamanho.getX() / 2), (posicao.getY() + tamanho.getY() / 2)));
        pontos.add(new PontoCartesiano((posicao.getX() + tamanho.getX() / 2), (posicao.getY() + tamanho.getY() / 2)));
        pontos.add(new PontoCartesiano((posicao.getX() + tamanho.getX() / 2), (posicao.getY() - tamanho.getY() / 2)));
        pontos.add(new PontoCartesiano((posicao.getX() - tamanho.getX() / 2), (posicao.getY() - tamanho.getY() / 2)));

        pontos.forEach((ponto) -> {
            glVertex2f(ponto.getX(), ponto.getY());
        });

        glEnd();

    }

    public void quicar() {

    }
}
