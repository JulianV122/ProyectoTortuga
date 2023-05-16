/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.Instructions;

/**
 *
 * @author Julian
 */
public class ForwardInstruction extends Instruction {
    private int distance;

    public void setDistance(int distancia){
        if (distancia<0){
            distance = distancia;
        }
    }
    
    public int getDistance(){
        return distance;
    }
    
}
