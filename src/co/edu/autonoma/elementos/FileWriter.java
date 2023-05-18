package co.edu.autonoma.elementos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileWriter {
    private RandomAccessFile archive;

    public FileWriter() {
    }

    public void setArchive(RandomAccessFile archive) {
        this.archive = archive;
    }

    public void write(ArrayList<String> lines) {
        try {
            for (String element : lines) {
                archive.writeBytes(element);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
