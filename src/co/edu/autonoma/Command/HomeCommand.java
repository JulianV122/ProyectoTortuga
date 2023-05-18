package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Turtle;

public class HomeCommand extends TurtleCommand{

    public HomeCommand(String instruction) {
        super(instruction);
    }
    
    /**
     * @param turtle
     * @return
     */
    @Override
    public void execute(Turtle turtle) {
    }
}
