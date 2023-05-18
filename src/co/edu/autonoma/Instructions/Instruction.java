/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.Instructions;

import co.edu.autonoma.elementos.Turtle;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public abstract class Instruction {
    private ArrayList instructionHistory;

    public Instruction() {
        this.instructionHistory = new ArrayList();
    }
    
    public abstract void execute(Turtle turtle);
    
    
}
