/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

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

    public Turtle(int x, int y) {
        super(x, y, 24, 24);
        xaux= x;
        yaux=y;
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

    public void backward(int distancia) {
        double radianes = Math.toRadians(address);
        int newX = x - (int) (distancia * Math.cos(radianes));
        int newY = y - (int) (distancia * Math.sin(radianes));
        xaux = x;
        yaux = y;
        x = newX;
        y = newY;
        drawable.redraw();
    }

    public void forward (int distancia,Instruccion ins) {
        double radianes = Math.toRadians(address);
        int newX = x + (int) (distancia * Math.cos(radianes));
        int newY = y + (int) (distancia * Math.sin(radianes));
        xaux = x;
        yaux = y;
        x = newX;
        y = newY;
        drawable.redraw();
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

    public Color changeColor(String new_color){
        Color color=new Color(0,0,0);
        if (new_color.equals("BLACK")){
            color = Color.BLACK;
        }
        return color;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.drawLine(xaux, yaux, x, y);
    }
}
