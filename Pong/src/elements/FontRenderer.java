/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.Font;
import org.newdawn.slick.TrueTypeFont;

/**
 *
 * @author udesc
 */
public class FontRenderer {

    public FontRenderer() {
        init();
    }

    TrueTypeFont font;

    public final void init() {
        // load a default java font
        Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
        font = new TrueTypeFont(awtFont, true);
    }

    public void escrever(PontoCartesiano pontoCartesiano, String texto) {
        font.drawString(pontoCartesiano.getX(), pontoCartesiano.getY(), texto);
    }
}
