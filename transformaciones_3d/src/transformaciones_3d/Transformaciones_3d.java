/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones_3d;

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
public class Transformaciones_3d extends JPanel{
    
    Scanner in;
    Scanner line;
    Edge[] edges;
    int[][] puntos;
    
     @Override
  public void paintComponent(Graphics g) {
      //super.paintComponent(g);

      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.blue);
      
      String nombre = "C:\\Users\\estiv\\OneDrive\\Documentos\\NetBeansProjects\\transformaciones_3d\\src\\transformaciones_3d\\casita3D.txt";
    
      try {
            in = new Scanner(new File(nombre));
            
            // Leer el número de puntos
            String lineString = in.nextLine();
            line = new Scanner(lineString );
            int numPuntos = line.nextInt();
            edges = new Edge[numPuntos];
            
            // Leer los puntos
            for(int punto = 0; punto < numPuntos; punto++) {
                lineString = in.nextLine();
                line = new Scanner(lineString);
                double x = line.nextDouble();
                double y = line.nextDouble();
                double z = line.nextDouble();
                edges[punto] = new Edge(x + 250,250 - y, z);
            }
            
            // Leer el número de puntos
            lineString = in.nextLine();
            line = new Scanner(lineString );
            int numVertices = line.nextInt();
            puntos = new int[numVertices][2];
            
            // Leer los puntos
            for(int vertice = 0; vertice < numVertices; vertice++) {
                lineString = in.nextLine();
                line = new Scanner(lineString);
                puntos[vertice][0] = line.nextInt();
                puntos[vertice][1] = line.nextInt();
               
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo " + nombre + " no se encuentra." + ex);
        } 
      
      dibujarCasita(g2d);
      
  }
  
  public void dibujarCasita(Graphics2D g2d){
      
        int d = -1000;
        
        for (int[] punto : puntos) {
            int inicio = punto[0];
            int fin = punto[1];
            Edge edge1 = edges[inicio];
            double d1 = edge1.getz()/d;
            Edge edge2 = edges[fin];
            double d2 = edge2.getz()/d;
            
            System.out.println(d1+" "+d2);
            
            double x1 = Math.round(edge1.getPoint1()/d1);
            double y1 = Math.round(edge1.getPoint2()/d1);
            double x2 = Math.round(edge2.getPoint1()/d2);
            double y2 = Math.round(edge2.getPoint2()/d2);
            
            System.out.println(x1+" "+y1+" "+x2+" "+y2);
            
            g2d.drawLine((int) x1,(int) y1,(int) x2,(int) y2);
        }
  } 
 
  public static void main(String[] args) {
      // Crear un nuevo Frame
      JFrame frame = new JFrame("transformaciones 3d");
      // Al cerrar el frame, termina la ejecución de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      frame.add(new Transformaciones_3d());
      // Asignarle tamaño
      frame.setSize(500, 500);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
  }
    
    
}
