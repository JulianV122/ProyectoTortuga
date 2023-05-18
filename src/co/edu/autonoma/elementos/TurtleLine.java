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
public class TurtleLine {
    private Color color;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public TurtleLine(Color color, int x1, int y1, int x2, int y2) {
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
