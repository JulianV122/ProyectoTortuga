/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.Instructions;

import co.edu.autonoma.elementos.Turtle;

/**
 *
 * @author Julian
 */
public class HomeInstruction extends Instruction {
    
    @Override
    public void execute(Turtle turtle) {
        turtle.setX(turtle.getInitialX());
        turtle.setY(turtle.getInitialY());
    }
    
}
