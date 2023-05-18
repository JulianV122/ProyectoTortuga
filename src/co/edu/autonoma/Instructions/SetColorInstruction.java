/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.Instructions;

import co.edu.autonoma.elementos.Turtle;
import java.awt.Color;

/**
 *
 * @author Julian
 */
public class SetColorInstruction extends Instruction {
    private Color color;
    
    public void setColor(String lineColor){
        lineColor = lineColor.toUpperCase();
        switch (lineColor) {
            case "BLACK" -> color = Color.BLACK;
            case "BLUE" -> color = Color.BLUE;
            case "CYAN" -> color = Color.CYAN;
            case "GRAY" -> color = Color.GRAY;
            case "GREEN" -> color = Color.GREEN;
            case "MAGENTA" -> color = Color.MAGENTA;
            case "ORANGE" -> color = Color.ORANGE;
            case "PINK" -> color = Color.PINK;
            case "RED" -> color = Color.RED;
            case "WHITE" -> color = Color.WHITE;
            case "YELLOW" -> color = Color.YELLOW;
        }
    }
    
    public Color getColor(){
        return color;
    }

    @Override
    public void execute(Turtle turtle) {
        turtle.color = color;
    }
}
