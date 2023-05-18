package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Commander;

import java.io.IOException;
import java.util.ArrayList;

public class LoadDataCommand extends DataCommand {
    public LoadDataCommand(String instruction) {
        super(instruction);
    }

    @Override
    public void execute(Commander commander) throws IOException {
        ArrayList<String> lines= commander.getFileReader().read();
        for (String line : lines) {
            TurtleCommand Cturtle = commander.getCoordinator().processdata(line);
            commander.execute(Cturtle);
        }
    }
}
