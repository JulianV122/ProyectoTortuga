/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import co.edu.autonoma.Instructions.Instruction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;

/**
 *
 * @author Julian
 */
public class Turtle extends Sprite {
    private int direction;
    public Color color;
    private BufferedImage image;
    private Drawable drawable;
    private LinkedList <TurtleLine> turtleLine; 
    private int initialX;
    private int initialY;

    public Turtle(int x, int y) {
        super(x, y, 24, 24);
        direction=0;
        initialX = x;
        initialY = y;
        turtleLine = new LinkedList<>();
        color = Color.BLACK;
    }

    
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void executeInstruction(Instruction instruction){
        instruction.execute(this);
    }
    

    @Override
    public void draw(Graphics g) {
        try {
            image = ImageIO.read(new File("src\\co\\edu\\autonoma\\Resources\\turtle.png"));
            g.drawImage(image, x, y, 64, 64, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(TurtleLine line: turtleLine){
            line.draw(g);
        }
    }

    @Override
    public void redraw() {
        drawable.redraw();
    }

    public int getInitialX() {
        return initialX;
    }

    public int getInitialY() {
        return initialY;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public LinkedList getTurtleLine(){
        return turtleLine;
    }

}
