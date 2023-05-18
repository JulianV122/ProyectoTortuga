/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elementos;

import co.edu.autonoma.Command.TurtleCommand;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author victor
 */

public class Turtle {
    public Point actualPoint;
    public Point pastPoint;
    public int width;
    public int height;
    public int address;
    public Color color;
    private BufferedImage image;
    private Drawable drawable;
    private ArrayList<Line> lines; // Lista para almacenar las líneas

    public Turtle() {
        this.actualPoint = new Point(200, 200);
        this.pastPoint = new Point(200, 200);
        this.width = 64;
        this.height = 64;
        this.address = 0;
        this.color = Color.BLACK;
        this.lines = new ArrayList<>();
    }

    public int getAddress() {
        return address;
    }

    public Point getActualPoint() {
        return actualPoint;
    }

    public Point getPastPoint() {
        return pastPoint;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public boolean executeCommand(TurtleCommand command) {
        command.execute(this);
        drawable.redraw();
        return true;
    }

    public void move(Point newpoint) {
        pastPoint = actualPoint;
        actualPoint = newpoint;
        lines.add(new Line(pastPoint, actualPoint, color)); // Almacenar la línea en la lista
    }

    public void turn(int angle) {
        address += angle;
    }

    public void draw(Graphics g) {
        try {
            image = ImageIO.read(new File("src\\co\\edu\\autonoma\\Resources\\turtle.png"));
            // Borrar el área ocupada por la imagen anterior
            g.clearRect(pastPoint.x, pastPoint.y, 64, 64);
            g.drawImage(image, actualPoint.x, actualPoint.y, 64, 64, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        drawLines(g); // Llamar al método para dibujar todas las líneas almacenadas
    }

   private void drawLines(Graphics g) {
        for (Line line : lines) {
            g.setColor(line.getColor());
            g.drawLine(line.getStartPoint().x, line.getStartPoint().y, line.getEndPoint().x, line.getEndPoint().y);
        }
    }

    public void changeColor(Color color) {
        this.color = color;
    }
}