/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

/**
 *
 * @author udesc
 */
public class PontoCartesiano {

    private float x;
    private float y;

    public PontoCartesiano(float x, float y) {
        setX(x);
        setY(y);
    }

    //x gon give it to ya
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public final void setX(float x) {
        this.x = x;
    }

    public final void setY(float y) {
        this.y = y;
    }

    public final void addY(float y) {
        this.y += y;
    }

    public final void addX(float x) {
        this.x += x;
    }
}
