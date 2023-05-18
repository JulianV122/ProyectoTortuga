package co.edu.autonoma.elementos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import java.util.ArrayList;

public class FileReader {
    private RandomAccessFile archive;

    public FileReader() {
    }

    public ArrayList<String> read() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = archive.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }
        return lines;
    }

    public void setArchive(RandomAccessFile archive) {
        this.archive = archive;
    }
}
