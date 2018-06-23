/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author udesc
 */
public class Box2D extends Movimento {

    public Box2D(long tela) {
        super(tela);
    }


    public final void setPosicao(float x, float y) {
        posicao.setX(x);
        posicao.setY(y);
    }

    public final void setTamanho(float x, float y) {
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
}
