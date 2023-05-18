/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.Instructions;

import co.edu.autonoma.elementos.Turtle;
import java.util.LinkedList;

/**
 *
 * @author Julian
 */
public class RepeatInstruction extends Instruction {
    private int nRepeticiones;
    private LinkedList<String> instrucciones;
    private String lineaInstruccion;
    
    public RepeatInstruction() {
        super("repeat");
        instrucciones = new LinkedList<>();
    }

    @Override
    public void execute(Turtle turtle) {

    }

    @Override
    public String getParameter() {
        return nRepeticiones+ " " + "[" + this.lineaInstruccion + "]"   ;
    }
    
    public int setNInstrucciones(int cantidadInstrucciones){
        if(cantidadInstrucciones > 0){
            this.nRepeticiones = cantidadInstrucciones;
        }
        return this.nRepeticiones;
    }
    
    public LinkedList<String> setInstrucciones(String instruccion){
        this.lineaInstruccion = instruccion;
        String[] listInstructions = instruccion.split(" ; ");
        for(int i = 0; i<listInstructions.length;i++){
            instrucciones.add(listInstructions[i]);
        }
        return instrucciones;
    }
    
}
