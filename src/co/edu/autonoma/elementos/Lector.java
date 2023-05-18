/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Julian
 */
public class Lector extends JFrame {
    
    public Lector() {
    }

    
     public String searchFile() {
        File fileName = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("TXT files", "txt");
        fileChooser.setFileFilter(txtFilter);
        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.CANCEL_OPTION) {
            fileName = fileChooser.getSelectedFile();
            return fileName.getPath();
        }
        return null;
    }

     public LinkedList readFile() {
        String file = searchFile();
        LinkedList <String> instrucciones = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                instrucciones.add(line);
            }
        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo" + e.getMessage());
        }
        return instrucciones;
    }
     
    }
