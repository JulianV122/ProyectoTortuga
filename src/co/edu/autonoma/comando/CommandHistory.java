package co.edu.autonoma.comando;

import co.edu.autonoma.Command.*;

import java.util.ArrayList;

public class CommandHistory {
    private ArrayList<String> history = new ArrayList<>();

    public void push(TurtleCommand command) {
        String checking = command.getInstruction();
        history.add(checking);
    }

    public ArrayList<String> getHistory() {
        return history;
    }
    
    
    public boolean isEmpty() { return history.isEmpty(); }

}