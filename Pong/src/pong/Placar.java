/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 *
 * @author Guilherme
 */
public class Placar {

    int placarDir, placarEsq;

    public Placar() {
        placarDir = 0;
        placarEsq = 0;
    }

    public void aumentarPlacarDireita() {
        placarDir++;
        System.out.println("Direita: " + placarDir + " Esquerda: " + placarEsq);

    }

    public void aumentarPlacarEsquerda() {
        placarEsq++;
        System.out.println("Direita: " + placarDir + " Esquerda: " + placarEsq);
    }

    public String getPlacarDireita() {
        return Integer.toString(this.placarDir);
    }

    public String getPlacarEsquerda() {
        return Integer.toString(this.placarEsq);
    }
}
