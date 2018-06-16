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
public abstract class AbstractEntity2D implements Entity2D {

    protected float x;
    protected float y;

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public abstract void setUp();

    @Override
    public abstract void destroy();

    @Override
    public abstract void draw();
}
