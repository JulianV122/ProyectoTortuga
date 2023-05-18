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
public class LeftTurnInstruction extends Instruction {
    private int degree;

    public LeftTurnInstruction() {
        super("LeftTurn");
    }
    
    public void setDegree(int degree){
        this.degree = degree;
    }
    
    public int getDegree(){
        return this.degree;
    }

    @Override
    public void execute(Turtle turtle) {
        if (degree > 0) {
            turtle.setDirection(turtle.getDirection()-degree);
        }
    }

    @Override
    public String getParameter() {
        return ""+degree;
    }
    
}
