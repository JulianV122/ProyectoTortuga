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
import co.edu.autonoma.Instructions.RepeatInstruction;
import co.edu.autonoma.Instructions.ResetInstruction;
import java.awt.Graphics;
import java.util.LinkedList;


/**
 *
 * @author Julian
 */
public class Coordinator extends Sprite implements Dimensionable{
    private Turtle turtle;
    private LinkedList <Instruction> instructions;
    private Lector lector;
    private Escritor escritor;
    private Fillable fillable;

    public Coordinator(int width, int height) {
        super(0, 0, width, height);
        turtle = new Turtle(width/2, height/2);
        turtle.setDrawable(this);
        turtle.setDimensionable(this);
        instructions = new LinkedList<>();
        lector = new Lector();
        escritor = new Escritor();
    }
    
    
    public void repeat(int amount, String instruction){}

    public void proccessData(String lineInstruction){
        Instruction newInstruction = null;
        String[] partes = lineInstruction.split(" ");
        String instruction = partes[0].toUpperCase();
        if (instruction.equals("RESET") || instruction.equals("R")){
            newInstruction = new ResetInstruction();
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
            fillable.fillList(newInstruction);
            return;
        }
        if (instruction.equals("HOME") || instruction.equals("H")){
            newInstruction = new HomeInstruction();
            turtle.executeInstruction(newInstruction);
            instructions.add(newInstruction);
            fillable.fillList(newInstruction);
            return;
        }
        if (instruction.equals("SAVE") || instruction.equals("S")){
            escritor.createFile("", this.instructions);
            return;
            
        }
        if (instruction.equals("LOAD") || instruction.equals("L")){
            LinkedList <String> listaInstrucciones = lector.readFile();
            for(String instruccion: listaInstrucciones){
                proccessData(instruccion);
            }
            return;
        }
        String color="";
        int value=0;
        if (partes.length > 1){
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
            else if(instruction.equals("BACKWARD") || instruction.equals("BD")){
                newInstruction = new BackwardInstruction();
                ((BackwardInstruction)newInstruction).setDistance(value);
                turtle.executeInstruction(newInstruction);
                instructions.add(newInstruction);
            }
            else if (instruction.equals("RIGHTTURN") || instruction.equals("RT")){
                newInstruction = new RightTurnInstruction();
                ((RightTurnInstruction)newInstruction).setDegree(value);
                turtle.executeInstruction(newInstruction);
                instructions.add(newInstruction);
            }
            else if (instruction.equals("LEFTTURN") || instruction.equals("LT")){
                newInstruction = new LeftTurnInstruction();
                ((LeftTurnInstruction)newInstruction).setDegree(value);
                turtle.executeInstruction(newInstruction);
                instructions.add(newInstruction);
            }
            else if (instruction.equals("SETCOLOR") || instruction.equals("SC")){
                newInstruction = new SetColorInstruction();
                ((SetColorInstruction)newInstruction).setColor(color);
                turtle.executeInstruction(newInstruction);
                instructions.add(newInstruction);
            }
            else if (instruction.equals("REPEAT")){
                newInstruction = new RepeatInstruction();
                int repeatValue = ((RepeatInstruction)newInstruction).setNInstrucciones(value);
                LinkedList<String> instructionList =((RepeatInstruction)newInstruction).setInstrucciones(lineInstruction.split("\\[")[1].split("\\]")[0]);
                for(int i = 0; i < repeatValue;i++){
                    for(String in: instructionList){
                        proccessData(in);
                    }
                }
            }
            else{
                System.out.println("NO EXISTE LA INSTRUCCION");
                return;
            }
            fillable.fillList(newInstruction);
        }
        else{
            System.out.println("NO EXISTE LA INSTRUCCION");
                return;
        }
    }

    
    public void draw(Graphics g){
        turtle.draw(g);
    }

    @Override
    public void redraw() {
        this.drawable.redraw();
    }

    public void setFillable(Fillable fillable) {
        this.fillable = fillable;
    }

    
    
    
}
