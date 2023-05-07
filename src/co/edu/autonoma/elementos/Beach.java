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
public class Beach extends Sprite {
    private Turtle turtle;

    public Beach(int width, int height) {
        super(0, 0, width, height);
        turtle = new Turtle(10, 10);
    }
    
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
        turtle.draw(g);
    }
    
}
