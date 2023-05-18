package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Turtle;
public abstract class TurtleCommand {
    public String instruction;

    public TurtleCommand(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    public abstract void execute(Turtle turtle);
}
