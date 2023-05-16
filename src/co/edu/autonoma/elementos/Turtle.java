/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import co.edu.autonoma.Instructions.BackwardInstruction;
import co.edu.autonoma.Instructions.ForwardInstruction;
import co.edu.autonoma.Instructions.SetColorInstruction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Julian
 */
public class Turtle extends Sprite {
    public int address;
    public Color color;
    private BufferedImage image;
    private Drawable drawable;
    private int xaux;
    private int yaux;
    private TurtleLine turtleLine;

    public Turtle(int x, int y) {
        super(x, y, 24, 24);
        xaux= x;
        yaux=y;
        turtleLine = new TurtleLine();
    }

    
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void turnLeft(int angulo) {
        address -= angulo;
        if (address < 0) {
            address += 360;
        }
    }

    public void turnRight(int angulo) {
        address += angulo;
        if (address >= 360) {
            address -= 360;
        }
    }

    public void backward(BackwardInstruction backward) {
        double radianes = Math.toRadians(address);
        int newX = x - (int) (backward.getDistance()* Math.cos(radianes));
        int newY = y - (int) (backward.getDistance() * Math.sin(radianes));
        xaux = x;
        yaux = y;
        x = newX;
        y = newY;
        drawable.redraw();
    }

    public void forward (ForwardInstruction forward) {
        double radianes = Math.toRadians(address);
        int newX = x + (int) (forward.getDistance() * Math.cos(radianes));
        int newY = y + (int) (forward.getDistance() * Math.sin(radianes));
        xaux = x;
        yaux = y;
        x = newX;
        y = newY;
        drawable.redraw();
    }
    
    public void setColor(SetColorInstruction SC){
        turtleLine.setColor(SC.getColor());
    }
    
    public void drawImage(Graphics g) {
        try {
            image = ImageIO.read(new File("src\\co\\edu\\autonoma\\Resources\\turtle.png"));
            g.drawImage(image, 50, 80, 64, 64, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void reset(){
        
    }
    
    public void home(){
        
    }

    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.drawLine(xaux, yaux, x, y);
    }

    @Override
    public void redraw() {
        drawable.redraw();
    }
}
