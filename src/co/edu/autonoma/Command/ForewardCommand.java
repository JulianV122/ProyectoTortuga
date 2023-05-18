package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Turtle;

import java.awt.*;

public class ForewardCommand extends TurtleCommand{
    private int distance;

    public ForewardCommand( String instruction) {
        super(instruction);
    }
    
    public void addOrder(int distance) {
        this.distance = distance;
    }

    @Override
    public void execute(Turtle turtle) {
        double radianes = Math.toRadians(turtle.getAddress());
        int newX = turtle.getActualPoint().x + (int) (distance * Math.cos(radianes));
        int newY = turtle.getActualPoint().y + (int) (distance * Math.sin(radianes));
        Point newpoint = new Point(newX, newY);
        turtle.move(newpoint);
    }
}
