/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
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

    public Turtle(int x, int y) {
        super(x, y, 24, 24);
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

    public void retroceder(int distancia) {
        double radianes = Math.toRadians(address);
        int newX = x - (int) (distancia * Math.cos(radianes));
        int newY = y - (int) (distancia * Math.sin(radianes));
        x = newX;
        y = newY;
        drawable.redraw();
    }

    public void back(int distancia) {
        double radianes = Math.toRadians(address);
        int newX = x + (int) (distancia * Math.cos(radianes));
        int newY = y + (int) (distancia * Math.sin(radianes));
        x = newX;
        y = newY;
        drawable.redraw();
    }
    
    public void drawImage(Graphics g) {
        try {
            image = ImageIO.read(new File("src\\co\\edu\\autonoma\\Resources\\turtle.png"));
            g.drawImage(image, 0, 0, 64, 64, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
