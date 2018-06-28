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
        this.placarDir = 0;
        this.placarEsq = 0;
    }

    public void aumentarPlacarDireita() {
        this.placarDir++;
        System.out.println("Aumentou direita!");
        
    }

    public void aumentarPlacarEsquerda() {
        this.placarEsq++;
        System.out.println("Aumentou esquerda!");
    }
    
    public int getPlacarDireita(){
        return this.placarDir;
    }
    
    public int getPlacarEsquerda(){
        return this.placarEsq;
    }

    public void fezPonto(float x) {
        if (x > 0.3) {
            aumentarPlacarDireita();
        } else {
            aumentarPlacarEsquerda();
        }
    }
}
