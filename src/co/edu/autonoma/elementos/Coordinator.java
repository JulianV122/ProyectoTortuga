/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import co.edu.autonoma.Instructions.BackwardInstruction;
import co.edu.autonoma.Instructions.SetColorInstruction;
import co.edu.autonoma.Instructions.RightTurnInstruction;
import co.edu.autonoma.Instructions.LeftTurnInstruction;
import co.edu.autonoma.Instructions.Instruction;
import co.edu.autonoma.Instructions.ForwardInstruction;
import java.awt.Graphics;


/**
 *
 * @author Julian
 */
public class Coordinator {
    private Turtle turtle;
    private Instruction instruccion;
    

    public Coordinator() {
        turtle = new  Turtle(50, 20);
    }
    
    public void repeat(int amount, String instruction){}

    public void proccessData(String instruction){
        String[] partes = instruction.split(" ");
        instruction = partes[0].toUpperCase();
        String color="";
        int distance=0;
        boolean isNumeric = (partes[1] != null && partes[1].matches("[0-9]+"));
        if (isNumeric){
            distance=Integer.parseInt(partes[1]);
        }
        else{
            color = partes[1];
        }
        
        if (instruction.equals("FORWARD") || instruction.equals("FD")){
            instruccion = new ForwardInstruction();
            ((ForwardInstruction)instruccion).setDistance(distance);
            turtle.forward((ForwardInstruction)instruccion);
        }
        if (instruction.equals("BACKWARD") || instruction.equals("BD")){
            instruccion = new BackwardInstruction();
            ((BackwardInstruction)instruccion).setDistance(distance);
            turtle.backward((BackwardInstruction)instruccion);
        }
        if (instruction.equals("RIGHTTURN") || instruction.equals("RT")){
            instruccion = new RightTurnInstruction();
        }
        if (instruction.equals("LEFTTURN") || instruction.equals("LT")){
            instruccion = new LeftTurnInstruction();
        }
        if (instruction.equals("SETCOLOR") || instruction.equals("SC")){
            instruccion = new SetColorInstruction();
            ((SetColorInstruction)instruccion).setColor(color);
            turtle.setColor((SetColorInstruction)instruccion);
        }
        if (instruction.equals("RESET") || instruction.equals("R")){
            turtle.reset();
        }
        if (instruction.equals("HOME") || instruction.equals("H")){
            turtle.home();
        }
        if (instruction.equals("SAVE") || instruction.equals("S")){
            
        }
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }
    
    public void draw(Graphics g){
        turtle.drawImage(g);
        turtle.draw(g);
    }

    
    
}
