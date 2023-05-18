package co.edu.autonoma.Command;

import co.edu.autonoma.elementos.Commander;

import java.io.IOException;
import java.util.ArrayList;

public class SaveDataCommand extends  DataCommand{
    public SaveDataCommand(String instruction) {
        super(instruction);
    }

    @Override
    public void execute(Commander commander) throws IOException {
        ArrayList<String> lines= commander.getFileReader().read();
        commander.getFilewriter().write(lines);
    }
}
