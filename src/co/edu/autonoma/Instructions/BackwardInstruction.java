/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.Instructions;

import co.edu.autonoma.elementos.Turtle;
import co.edu.autonoma.elementos.TurtleLine;

/**
 *
 * @author Julian
 */
public class BackwardInstruction extends Instruction{
    private int distance;
    
    public void setDistance(int distancia){
        if (distancia>0){
            distance = distancia;
        }
    }
    
    public int getDistance(){
        return distance;
    }

    @Override
    public void execute(Turtle turtle) {
        double newX = turtle.getX() - (Math.sin(Math.toRadians(turtle.getDirection())) * distance);  
        double newY = turtle.getY() + (Math.cos(Math.toRadians(turtle.getDirection())) * distance);
        TurtleLine line = new TurtleLine(turtle.color, turtle.getX(), turtle.getY(),(int)Math.round(newX) , (int)Math.round(newY));
        turtle.setX((int)Math.round(newX));
        turtle.setY((int)Math.round(newY));
        turtle.getTurtleLine().add(line);
    }
}
