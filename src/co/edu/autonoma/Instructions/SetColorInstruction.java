/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.Instructions;

import java.awt.Color;

/**
 *
 * @author Julian
 */
public class SetColorInstruction extends Instruction {
    private Color color;
    
    public void setColor(String lineColor){
        lineColor = lineColor.toUpperCase();
        switch (lineColor){
            case "BLACK":
                color = Color.BLACK;
        }
        switch (lineColor){
            case "BLUE":
                color = Color.BLUE;
        }
        switch (lineColor){
            case "CYAN":
                color = Color.CYAN;
        }
        switch (lineColor){
            case "GRAY":
                color = Color.GRAY;
        }
        switch (lineColor){
            case "GREEN":
                color = Color.GREEN;
        }
        switch (lineColor){
            case "MAGENTA":
                color = Color.MAGENTA;
        }
        switch (lineColor){
            case "ORANGE":
                color = Color.ORANGE;
        }
        switch (lineColor){
            case "PINK":
                color = Color.PINK;
        }
        switch (lineColor){
            case "RED":
                color = Color.RED;
        }
        switch (lineColor){
            case "WHITE":
                color = Color.WHITE;
        }
        switch (lineColor){
            case "YELLOW":
                color = Color.YELLOW;
        }
    }
    
    public Color getColor(){
        return color;
    }
}
