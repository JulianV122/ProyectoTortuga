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
public class HomeInstruction extends Instruction {

    public HomeInstruction() {
        super("Home");
    }
    
    @Override
    public void execute(Turtle turtle) {
        TurtleLine line = new TurtleLine(turtle.color, turtle.getX()+turtle.getWidth()/2, turtle.getY()+turtle.getHeight()/2,turtle.getInitialX()+turtle.getWidth()/2 , turtle.getInitialY()+turtle.getHeight()/2);
        turtle.setX(turtle.getInitialX());
        turtle.setY(turtle.getInitialY());
        turtle.getTurtleLine().add(line);
    }

    @Override
    public String getParameter() {
        return "";
    }
    
}
