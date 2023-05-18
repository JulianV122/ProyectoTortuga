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
import co.edu.autonoma.Instructions.HomeInstruction;
import co.edu.autonoma.Instructions.ResetInstruction;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


/**
 *
 * @author Julian
 */
public class Coordinator extends Sprite{
    private Turtle turtle;
    private LinkedList <Instruction> instructions;
    private Lector lector;
    private Escritor escritor;

    public Coordinator(int width, int height) {
        super(0, 0, width, height);
        turtle = new Turtle(width/3, height/3);
        instructions = new LinkedList<>();
    }
    
    
    public void repeat(int amount, String instruction){}

    public void proccessData(String instruction){
        Instruction newInstruction = null;
        String[] partes = instruction.split(" ");
        instruction = partes[0].toUpperCase();
        if (instruction.equals("RESET") || instruction.equals("R")){
            newInstruction = new ResetInstruction();
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
            return;
        }
        if (instruction.equals("HOME") || instruction.equals("H")){
            newInstruction = new HomeInstruction();
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
            return;
        }
        if (instruction.equals("SAVE") || instruction.equals("S")){
            
            return;
            
        }
        if (instruction.equals("LOAD") || instruction.equals("L")){
            
            return;
        }
        String color="";
        int value=0;
        boolean isNumeric = (partes[1] != null && partes[1].matches("[0-9]+"));
        if (isNumeric){
            value=Integer.parseInt(partes[1]);
        }
        else{
            color = partes[1];
        }
        
        
        if (instruction.equals("FORWARD") || instruction.equals("FD")){
            newInstruction = new ForwardInstruction();
            ((ForwardInstruction)newInstruction).setDistance(value);
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
        }
        if (instruction.equals("BACKWARD") || instruction.equals("BD")){
            newInstruction = new BackwardInstruction();
            ((BackwardInstruction)newInstruction).setDistance(value);
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
        }
        if (instruction.equals("RIGHTTURN") || instruction.equals("RT")){
            newInstruction = new RightTurnInstruction();
            ((RightTurnInstruction)newInstruction).setDegree(value);
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
        }
        if (instruction.equals("LEFTTURN") || instruction.equals("LT")){
            newInstruction = new LeftTurnInstruction();
            ((LeftTurnInstruction)newInstruction).setDegree(value);
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
        }
        if (instruction.equals("SETCOLOR") || instruction.equals("SC")){
            newInstruction = new SetColorInstruction();
            ((SetColorInstruction)newInstruction).setColor(color);
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
        }
        
    }

    
    public void draw(Graphics g){
        //g.setColor(Color.white);
        //g.fillRect(x, y, 432,432);
        //turtle.drawImage(g);
        turtle.draw(g);
    }

    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
