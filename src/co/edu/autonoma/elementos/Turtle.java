/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

/**
 *
 * @author Julian
 */
public class Turtle extends Sprite {
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;

    public Turtle(int x, int y) {
        super(x, y, 24, 24);
    }
    
    public void forward (int distance){
        
    } 
    
    
    public void drawImage(Graphics g, ImageObserver parent) {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("src\\co\\edu\\autonoma\\Resources\\turtle.png")));
            g.drawImage(image, 0, 0, 64, 64, parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
}
