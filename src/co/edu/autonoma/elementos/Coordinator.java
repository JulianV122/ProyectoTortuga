/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import co.edu.autonoma.Command.BackwardCommand;
import co.edu.autonoma.Command.TurtleCommand;
import co.edu.autonoma.Command.ForewardCommand;
import co.edu.autonoma.Command.*;

import java.awt.*;

/**
 *
 * @author Julian
 */
public class Coordinator {

    public DataCommand processdatacommand(String instruction){
        instruction = instruction.toUpperCase();
        if (instruction.contains("SAVE") || instruction.contains("S")){
            return new SaveDataCommand(instruction);

        }else if (instruction.contains("LOAD") || instruction.contains("L")){
            return new LoadDataCommand(instruction);
        }
        return null;
    }
    public TurtleCommand processdata(String instruction){
        String[] partes = instruction.split(" ");
        String typeinstruction = partes[0].toUpperCase();
        String color = null;
        int distance = 0;
        Color linecolor = null;
        boolean isNumeric = (partes[1] != null && partes[1].matches("[0-9]+"));
        if (isNumeric){
            distance=Integer.parseInt(partes[1]);
        }
        else{
            color = partes[1];
            linecolor = selectcolor(color);
        }

        if (typeinstruction.equals("FORWARD") || typeinstruction.equals("FD")){
            ForewardCommand forewardcomand = new ForewardCommand(instruction);
            forewardcomand.addOrder(distance);
            return forewardcomand;
        }
        else if (typeinstruction.equals("BACKWARD") || typeinstruction.equals("BD")){
            BackwardCommand backwardcomand = new BackwardCommand(instruction);
            backwardcomand.addOrder(distance);
            return backwardcomand;
        }
        else if  (typeinstruction.equals("RIGHTTURN") || typeinstruction.equals("RT")){
            RightTurnCommand rigthturncommand = new RightTurnCommand(instruction);
            rigthturncommand.setAngle(distance);
            return rigthturncommand;
        }
        else if  (typeinstruction.equals("LEFTTURN") || typeinstruction.equals("LT")){
            LeftTurnCommand leftturncommand = new LeftTurnCommand(instruction);
            leftturncommand.setAngle(distance);
            return leftturncommand;
        }
        else if  (typeinstruction.equals("SETCOLOR") || typeinstruction.equals("SC")){
            ChangeColorCommand setcolorcommand = new ChangeColorCommand(instruction);
            setcolorcommand.setColor(linecolor);
            return setcolorcommand;
        }
        else if  (typeinstruction.equals("RESET") || typeinstruction.equals("R")){
            ResetCommmand resetcommand = new ResetCommmand(instruction);
            return resetcommand;

        }
        else if  (typeinstruction.equals("HOME") || typeinstruction.equals("H")){
            HomeCommand homecommand = new HomeCommand(instruction);
            return homecommand;
        }

        return null;
    }
    
    
    public Color selectcolor(String color){
        color = color.toUpperCase();
        Color linecolor =  null;
        switch (color) {
            case "BLACK" -> linecolor = Color.BLACK;
            case "BLUE" -> linecolor = Color.BLUE;
            case "CYAN" -> linecolor = Color.CYAN;
            case "GRAY" -> linecolor = Color.GRAY;
            case "GREEN" -> linecolor = Color.GREEN;
            case "MAGENTA" -> linecolor = Color.MAGENTA;
            case "ORANGE" -> linecolor = Color.ORANGE;
            case "PINK" -> linecolor = Color.PINK;
            case "RED" -> linecolor = Color.RED;
            case "WHITE" -> linecolor = Color.WHITE;
            case "YELLOW" -> linecolor = Color.YELLOW;
        }
        return linecolor;
    }

    public RepeatCommand createRepeatCommand(String command){
        return new RepeatCommand(command);
    }


}
