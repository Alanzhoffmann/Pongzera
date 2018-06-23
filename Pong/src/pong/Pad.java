/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import elements.Box2D;

/**
 *
 * @author Guilherme
 */
public class Pad extends Box2D {

    public Pad(long tela) {
        super(tela);
        setVelocidade(0.05f);
        setTamanho(0.1f, 0.4f);
    }
}
