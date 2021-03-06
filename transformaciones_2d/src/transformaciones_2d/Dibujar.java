/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones_2d;

/**
 *
 * @author estiv
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Dibujar extends JPanel{
    
    Scanner in;
    Scanner line;
    
     @Override
  public void paintComponent(Graphics g) {
      //super.paintComponent(g);

      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.blue);
      
      String nombre = "C:\\Users\\estiv\\OneDrive\\Documentos\\NetBeansProjects\\libreria_matematica_y_casita\\src\\libreria_matematica_y_casita\\casita.txt";
    //String nombre = "C:\\Users\\estiv\\OneDrive\\Documentos\\NetBeansProjects\\libreria_matematica_y_casita\\src\\libreria_matematica_y_casita\\gancho.txt";
    
      try {
            in = new Scanner(new File(nombre));
            
            // Leer el número de puntos
            String lineString = in.nextLine();
            line = new Scanner(lineString );
            int numPuntos = line.nextInt();
            Edge[] edges = new Edge[numPuntos];
            
            
            // Leer los puntos
            for(int punto = 0; punto < numPuntos; punto++) {
                lineString = in.nextLine();
                line = new Scanner(lineString);
                int x = line.nextInt();
                int y = line.nextInt();
                edges[punto] = new Edge(x + 250,250 - y);
            }
            
            // Leer el número de puntos
            lineString = in.nextLine();
            line = new Scanner(lineString );
            int numVertices = line.nextInt();
            
            // Leer los puntos
            for(int vertice = 0; vertice < numVertices; vertice++) {
                lineString = in.nextLine();
                line = new Scanner(lineString);
                int inicio = line.nextInt();
                int fin = line.nextInt();
                Edge i = edges[inicio];
                Edge f = edges[fin];
                
                g2d.drawLine(i.getPoint1(), i.getPoint2(), f.getPoint1(), f.getPoint2());
               
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo " + nombre + " no se encuentra." + ex);;
        } 

  }
 
 

  public static void main(String[] args) {
      // Crear un nuevo Frame
      JFrame frame = new JFrame("Dibujar");
      // Al cerrar el frame, termina la ejecución de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      frame.add(new Dibujar());
      // Asignarle tamaño
      frame.setSize(500, 500);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
  }
}
