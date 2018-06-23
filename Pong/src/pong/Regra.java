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

    public static void colisao(ArrayList<Bola> bolas, ArrayList<Pad> pads) {
        for (Pad pad : pads) {
            for (Bola bola : bolas) {
                if (bola.coincidente(pad)) {
                    bola.inverteDirecaoHorizontal();
                }
            }
        }
    }

    public static void colisao(Bola bola, Pad pad1, Pad pad2) {
        ArrayList<Bola> bolas = new ArrayList<>();
        bolas.add(bola);

        ArrayList<Pad> pads = new ArrayList<>();
        pads.add(pad1);
        pads.add(pad2);

        colisao(bolas, pads);
    }
}
