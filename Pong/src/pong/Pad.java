/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import elements.Box2D;
import elements.PontoCartesiano;

/**
 *
 * @author Guilherme
 */
public class Pad extends Box2D {

    private final PontoCartesiano tamanhoOriginal = new PontoCartesiano(0.1f, 0.5f);
    private final float fatorDeReducao = 0.05f;

    public Pad(long tela) {
        super(tela);
        setVelocidade(0.05f);
        setTamanho(tamanhoOriginal.getX(), tamanhoOriginal.getY());
    }

    public void diminuirTamanhoY() {
        setTamanho(tamanhoOriginal.getX(), tamanho.getY() - fatorDeReducao);
    }

    public void resetarTamanho() {
        setTamanho(tamanhoOriginal.getX(), tamanhoOriginal.getY());
    }
}
