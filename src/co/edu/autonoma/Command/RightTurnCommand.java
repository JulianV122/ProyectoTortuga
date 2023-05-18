package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Turtle;

public class RightTurnCommand extends TurtleCommand {
    private int angle;

    public RightTurnCommand(String instruction) {
        super(instruction);
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    /**
     * @param turtle 
     */
    @Override
    public void execute(Turtle turtle) {
        if (turtle.getAddress() >= 360) {
            turtle.turn(-360);
        }else {
            turtle.turn(angle);
        }
    }
}
