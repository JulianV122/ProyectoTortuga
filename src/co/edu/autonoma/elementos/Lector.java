/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class Lector {
    private RandomAccessFile archive;
    private ArrayList<String> instructions;
    private Coordinator coordinador;
    
    public Lector(RandomAccessFile archive) throws FileNotFoundException {
        try {
            this.archive = new RandomAccessFile("src\\co\\edu\\autonoma\\elementos\\Logo.txt", "r");
        } catch (Exception e) {
            this.archive = new RandomAccessFile("src\\co\\edu\\autonoma\\elementos\\Logo.txt", "rw");
        }
    }

    public void load() throws FileNotFoundException, IOException {
        try {
            if(this.archive.length() != 0) {
                read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() {}

    public void read() {
        Charset charset = StandardCharsets.UTF_8;
        try (BufferedReader reader = Files.newBufferedReader((Path) archive, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                coordinador.proccessData(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
    
    public void read(String text){
        coordinador.proccessData(text);
    }
    

    public void extractData() {}
}