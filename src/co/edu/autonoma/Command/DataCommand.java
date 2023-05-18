/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Commander;

import java.io.IOException;

/**
 *
 * @author victo
 */
public class DataCommand {
    public String instruction;

    public DataCommand(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    public void execute(Commander commander) throws IOException {
    }
}
