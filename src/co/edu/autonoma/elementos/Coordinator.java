/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.awt.Color;

/**
 *
 * @author Julian
 */
public class Coordinator {
    private Turtle turtle;

    public Coordinator() {
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
            turtle.forward(distance);
        }
        if (instruction.equals("BACKWARD") || instruction.equals("BD")){
            turtle.backward(distance);
        }
        if (instruction.equals("RIGHTTURN") || instruction.equals("RT")){
            turtle.turnRight(distance);
        }
        if (instruction.equals("LEFTTURN") || instruction.equals("LT")){
            turtle.turnLeft(distance);
        }
        if (instruction.equals("SETCOLOR") || instruction.equals("SC")){
            turtle.changeColor(color);
        }
        if (instruction.equals("RESET") || instruction.equals("R")){
            turtle.reset();
        }
        if (instruction.equals("HOME") || instruction.equals("H")){
            turtle.home();
        }
        if (instruction.equals("SAVE") || instruction.equals("S")){
            turtle.changeColor(color);
        }
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }
    
    
}
