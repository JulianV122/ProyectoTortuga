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
public class ForwardInstruction extends Instruction {
    private int distance;

    public ForwardInstruction() {
        super("Forward");
    }

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
        double newX = turtle.getX() + (Math.sin(Math.toRadians(turtle.getDirection())) * distance);  
        double newY = turtle.getY() - (Math.cos(Math.toRadians(turtle.getDirection())) * distance);
        if (newX+turtle.getWidth() > turtle.getDimensionable().getWidth()){
            newX = turtle.getDimensionable().getWidth()-turtle.getWidth();
        }
        if (newY < 0){
            newY = 0;
        }
        if (newX < 0){
            newX = 0;
        }
        if(newY + turtle.getHeight() > turtle.getDimensionable().getHeight()){
            newY = turtle.getDimensionable().getHeight()-turtle.getHeight();
        }
        TurtleLine line = new TurtleLine(turtle.color, turtle.getX()+turtle.getWidth()/2, turtle.getY()+turtle.getHeight()/2,(int)Math.round(newX)+turtle.getWidth()/2 , (int)Math.round(newY)+turtle.getHeight()/2);
        turtle.setX((int)Math.round(newX));
        turtle.setY((int)Math.round(newY));
        turtle.getTurtleLine().add(line);
    }

    @Override
    public String getParameter() {
    return ""+distance;
    }
    
}
