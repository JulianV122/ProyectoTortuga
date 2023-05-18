package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Turtle;

import java.awt.*;

public class BackwardCommand extends TurtleCommand {
    public int distance;

    public BackwardCommand(String instruction) {
        super(instruction);
    }

    /**
     *
     * @param distance
     */
    public void addOrder(int distance) {
        this.distance = distance;
    }

    @Override
    public void execute(Turtle turtle) {
        double radianes = Math.toRadians(turtle.getAddress());
        int newX = turtle.getActualPoint().x - (int) (distance * Math.cos(radianes));
        int newY = turtle.getActualPoint().y - (int) (distance * Math.sin(radianes));
        Point newpoint = new Point(newX, newY);
        turtle.move(newpoint);
    }
}