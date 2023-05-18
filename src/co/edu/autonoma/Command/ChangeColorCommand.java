package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Turtle;

import java.awt.*;

public class ChangeColorCommand extends TurtleCommand {
    public Color color;

    public ChangeColorCommand(String instruction) {
        super(instruction);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @param turtle
     */
    @Override
    public void execute(Turtle turtle) {
        turtle.changeColor(color);
    }
}
