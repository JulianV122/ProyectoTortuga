/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Julian
 */
public class Beach extends Sprite implements Drawable{
    private Drawable drawable;
    private Turtle turtle;

    public Beach(int width, int height) {
        super(0, 0, width, height);
        turtle = new Turtle(50, 20);
    }
    
    
    @Override
    public void draw(Graphics g) {
        Color color = new Color(255, 202, 40);
        g.setColor(color);
        g.fillRect(x, y, width, height);
        turtle.drawImage(g);
        turtle.draw(g);
    }

    @Override
    public void redraw() {
        drawable.redraw();
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
