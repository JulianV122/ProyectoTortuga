/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;
import co.edu.autonoma.Instructions.Instruction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Julian
 */
public class Escritor extends JFrame {
    public String selectPath(){
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("TXT files", "txt");
        fileChooser.setFileFilter(txtFilter);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile().getPath();
        }
        return null;
    }

    public void createFile(String fileName,LinkedList<Instruction> instrucciones) {
        String filePath= selectPath()+fileName+".txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            writeFile(instrucciones, filePath);
            System.out.println("El archivo se ha creado con exito en: " + filePath);
        } catch (IOException e) {
            System.out.println("No se ha podido crear el archivo" + e.getMessage());
        }
    }

    public void writeFile(LinkedList<Instruction> instrucciones, String file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            for (Instruction line : instrucciones) {
                writer.write(line.getNameInstruction() +" " + line.getParameter() + "\n");
            }
        }
    }
}
