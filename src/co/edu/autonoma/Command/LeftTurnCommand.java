package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Turtle;

public class LeftTurnCommand extends TurtleCommand {
    public int angle;

    public LeftTurnCommand(String instruction) {
        super(instruction);
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    /**
     * @param turtle
     * @return
     */
    @Override
    public void execute(Turtle turtle) {
        if (turtle.getAddress() < 0) {
            turtle.turn(360);
        }else {
            turtle.turn(-1 * angle);
        }
    }
}
