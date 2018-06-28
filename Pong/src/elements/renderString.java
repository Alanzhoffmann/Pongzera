/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import org.lwjgl.opengl.GL11;

/**
 *
 * @author Guilherme
 */
public class renderString {

    public static void drawString(int c, float x, float y) {
        float startX = x;
        GL11.glBegin(GL11.GL_POINTS);
        GL11.glVertex2f(x, y);
        switch (c) {
            case '1':
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 1; i <= 8; i++) {
                    GL11.glVertex2f(x + 4, y + i);
                }
                GL11.glVertex2f(x + 3, y + 7);
                x += 8;
                break;
            case '2':
                for (int i = 1; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y + 8);
                }
                GL11.glVertex2f(x + 1, y + 7);
                GL11.glVertex2f(x + 1, y + 6);
                GL11.glVertex2f(x + 6, y + 7);
                GL11.glVertex2f(x + 6, y + 6);
                GL11.glVertex2f(x + 6, y + 5);
                GL11.glVertex2f(x + 5, y + 4);
                GL11.glVertex2f(x + 4, y + 3);
                GL11.glVertex2f(x + 3, y + 2);
                GL11.glVertex2f(x + 2, y + 1);
                x += 8;
                break;
            case '3':
                for (int i = 1; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y + 8);
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 6, y + i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y + 4);
                }
                x += 8;
                break;
            case '4':
                for (int i = 2; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y + i);
                }
                for (int i = 2; i <= 7; i++) {
                    GL11.glVertex2f(x + i, y + 1);
                }
                for (int i = 0; i <= 4; i++) {
                    GL11.glVertex2f(x + 4, y + i);
                }
                x += 8;
                break;
            case '5':
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + i, y + 8);
                }
                for (int i = 4; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y + i);
                }
                GL11.glVertex2f(x + 1, y + 1);
                GL11.glVertex2f(x + 2, y);
                GL11.glVertex2f(x + 3, y);
                GL11.glVertex2f(x + 4, y);
                GL11.glVertex2f(x + 5, y);
                GL11.glVertex2f(x + 6, y);
                GL11.glVertex2f(x + 7, y + 1);
                GL11.glVertex2f(x + 7, y + 2);
                GL11.glVertex2f(x + 7, y + 3);
                GL11.glVertex2f(x + 6, y + 4);
                GL11.glVertex2f(x + 5, y + 4);
                GL11.glVertex2f(x + 4, y + 4);
                GL11.glVertex2f(x + 3, y + 4);
                GL11.glVertex2f(x + 2, y + 4);
                x += 8;
                break;
            case '6':
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y + i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y + 4);
                    GL11.glVertex2f(x + i, y + 8);
                }
                GL11.glVertex2f(x + 7, y + 1);
                GL11.glVertex2f(x + 7, y + 2);
                GL11.glVertex2f(x + 7, y + 3);
                GL11.glVertex2f(x + 6, y + 4);
                x += 8;
                break;
            case '7':
                for (int i = 0; i <= 7; i++) {
                    GL11.glVertex2f(x + i, y + 8);
                }
                GL11.glVertex2f(x + 7, y + 7);
                GL11.glVertex2f(x + 7, y + 6);
                GL11.glVertex2f(x + 6, y + 5);
                GL11.glVertex2f(x + 5, y + 4);
                GL11.glVertex2f(x + 4, y + 3);
                GL11.glVertex2f(x + 3, y + 2);
                GL11.glVertex2f(x + 2, y + 1);
                GL11.glVertex2f(x + 1, y);
                x += 8;
                break;
            case '8':
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y + i);
                    GL11.glVertex2f(x + 7, y + i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y + 8);
                    GL11.glVertex2f(x + i, y + 0);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y + 4);
                }
                x += 8;
                break;
            case '9':
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 7, y + i);
                }
                for (int i = 5; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y + i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y + 8);
                    GL11.glVertex2f(x + i, y + 0);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y + 4);
                }
                GL11.glVertex2f(x + 1, y + 0);
                x += 8;
                break;
            case '.':
                GL11.glVertex2f(x + 1, y);
                x += 2;
                break;
            case ',':
                GL11.glVertex2f(x + 1, y);
                GL11.glVertex2f(x + 1, y + 1);
                x += 2;
                break;
            case '\n':
                y -= 10;
                x = startX;
                break;
            case ' ':
                x += 8;
                break;
            default:
                break;
        }
        GL11.glEnd();
    }
}
