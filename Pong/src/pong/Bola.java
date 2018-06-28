/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import elements.Box2D;
import elements.Movimento;
import elements.PontoCartesiano;

/**
 *
 * @author Guilherme
 */
public class Bola extends Box2D {

    boolean vertical = limiteVertical(true), horizontal = limiteHorizontal(true);
    PontoCartesiano posicaoInicial = new PontoCartesiano(0, 0);
    float aceleracao = 0.0005f;
    float velocidadeInicial = 0.03f;
    Placar placar = new Placar();

    public Bola(long tela) {
        super(tela);
        setVelocidade(velocidadeInicial);
        setTamanho(0.05f, 0.05f);
    }

    public void setPosicaoInicial(float x, float y) {
        posicaoInicial.setX(x);
        posicaoInicial.setY(y);
        setPosicao(x, y);
    }

    public void quicar() {
        if (limiteVertical(vertical)) {
            inverteDirecaoVertical();
        }
        if (limiteHorizontal(horizontal)) {
            placar.fezPonto(posicao.getX());
            setPosicao(posicaoInicial.getX(), posicaoInicial.getY());
            setVelocidade(velocidadeInicial);
        }
        movimentarHorizontal(horizontal);
        movimentarVertical(vertical);
    }

    public void inverteDirecaoHorizontal() {
        horizontal = !horizontal;
    }

    public void inverteDirecaoVertical() {
        vertical = !vertical;
    }

    public boolean verificaLimite(Movimento objeto) {

        boolean retorno = horizontal
                ? objeto.getPosicaoX() > getPosicaoX()
                : objeto.getPosicaoX() < getPosicaoX();

        if (!retorno) {
            setPosicao(objeto.getPosicaoX(), getPosicaoY());
        }

        return retorno;
    }

    public void aumentarVelocidade() {
        setVelocidade(getVelocidade() + aceleracao);
    }
}
