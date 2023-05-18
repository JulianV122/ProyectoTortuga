package co.edu.autonoma.elementos;

import co.edu.autonoma.Command.DataCommand;
import co.edu.autonoma.Command.TurtleCommand;
import co.edu.autonoma.comando.CommandHistory;
import java.awt.Graphics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Commander {
    private RandomAccessFile archive;
    private CommandHistory record;
    private FileReader fileReader;
    private FileWriter filewriter;
    private Turtle turtle;
    private Coordinator coordinator;
    public Drawable drawable;

    @SuppressWarnings("empty-statement")
    public Commander() throws FileNotFoundException {
        try {
            this.archive = new RandomAccessFile("src\\co\\edu\\autonoma\\Resources\\rectángulo.logo", "r");
        } catch (FileNotFoundException e) {
            this.archive = new RandomAccessFile("src\\co\\edu\\autonoma\\Resources\\rectángulo.logo", "rw");
        };
        this.record = new CommandHistory();
        this.turtle = new Turtle();
        this.coordinator = new Coordinator();
        this.fileReader = new FileReader();
        this.filewriter = new FileWriter();
        filewriter.setArchive(archive);
        fileReader.setArchive(archive);
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public FileWriter getFilewriter() {
        return filewriter;
    }

    public void coordinatoraction(String action) throws IOException {
        action = action.toUpperCase();
            if(
                    action.contains("SAVE") ||
                            action.contains("S") ||
                            action.equals("LOAD") ||
                            action.equals("L"))
            {
                DataCommand order = coordinator.processdatacommand(action);
                execute(order);
            } else{
                coordinator.processdata(action);
                TurtleCommand order = coordinator.processdata(action);
                execute(order);
            }
        }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void execute(DataCommand command) throws IOException {
        command.execute(this);
    }
    public void execute(TurtleCommand command){
        if (turtle.executeCommand(command)) {
            record.push(command);
        }
    }
    
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        turtle.setDrawable(drawable);
    }

    public CommandHistory getRecord() {
        return record;
    }
    
    public void draw(Graphics g){
        turtle.draw(g);
    }
}
