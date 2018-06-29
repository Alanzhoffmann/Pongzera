/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class Regra {

    private static Regra regra;

    public static Regra getInstance() {
        if (regra == null) {
            regra = new Regra();
        }
        return regra;
    }

    private Placar placar = new Placar();

    ArrayList<Bola> bolas;
    ArrayList<Pad> pads;

    private Regra() {

    }

    public void adicionarBola(Bola bola) {
        if (bolas == null) {
            bolas = new ArrayList<>();
        }
        bolas.add(bola);
    }

    public void adicionarPad(Pad pad) {
        if (pads == null) {
            pads = new ArrayList<>();
        }
        pads.add(pad);
    }

    public void verificarColisao() {
        for (Pad pad : pads) {
            for (Bola bola : bolas) {
                if (bola.coincidente(pad)) {

                    if (pad.getPosicaoX() > bola.getPosicaoX()) {
                        //Pad direito
                        bola.setPosicao(pad.getLimiteEsquerdo() - bola.getTamanhoX() / 2, bola.getPosicaoY());
                    } else {
                        //Pad esquerdo
                        bola.setPosicao(pad.getLimiteDireito() + bola.getTamanhoX() / 2, bola.getPosicaoY());
                    }

                    bola.inverteDirecaoHorizontal();
                    bola.aumentarVelocidade();
                    pad.diminuirTamanhoY();
                }
            }
        }
    }

    public void marcarPonto(float posicao) {
        if (posicao < 0) {
            placar.aumentarPlacarDireita();
        } else {
            placar.aumentarPlacarEsquerda();
        }
        resetarJogo();
    }

    public void resetarJogo() {
        for (Bola bola : bolas) {
            bola.resetarBola();
        }
        for (Pad pad : pads) {
            pad.resetarTamanho();
        }
    }
}
