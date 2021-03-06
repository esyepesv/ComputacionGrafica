/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones_2d;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author estiv
 */
public final class Transformaciones_2d extends JPanel
    implements KeyListener {

    Scanner in;
    Scanner line;
    public int[][] vertices;
    public int[][] puntos;
    Line2D.Double linea1;
    
    public Transformaciones_2d() {
        linea1 = new Line2D.Double();
        this.addKeyListener(this);
        leerArchivo();
    }
    
     @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.blue);
      dibujar(g2d);
  }
   
  
  public void dibujar(Graphics2D g2d){
        for (int[] vertice : vertices) {
            int inicio = vertice[0];
            int fin = vertice[1];
            linea1.x1 = puntos[inicio][0];
            linea1.y1 = puntos[inicio][1];
            linea1.x2 = puntos[fin][0];
            linea1.y2 = puntos[fin][1];
            g2d.draw(linea1);
        }      
  }
  
  public void nuevosPuntos(Matrix3x3 m){
        for (int[] punto : puntos) {
            Point3 p = new Point3(punto[0], punto[1], 1);
            p = Matrix3x3.times(m,p);
            punto[0] = (int) p.getx();
            punto[1] = (int) p.gety();
        }
  }
  
  public void traslacion(int dx, int dy){
      Matrix3x3 m = new Matrix3x3(1, 0, dx,
                                  0, 1, dy,
                                  0, 0, 1 );
      nuevosPuntos(m);
  }
  
  public void rotacion(double angulo){
      Matrix3x3 m = new Matrix3x3(Math.cos(angulo), -(Math.sin(angulo)), 0,
                                  Math.sin(angulo), Math.cos(angulo), 0,
                                  0, 0, 1 );
      int xi = puntos[0][0];
      int yi = puntos[0][1];
      nuevosPuntos(m);
      int xf = puntos[0][0];
      int yf = puntos[0][1];
      traslacion(xi-xf,yi-yf);
  }
  
  public void escalamiento(double sx, double sy){
      Matrix3x3 m = new Matrix3x3(sx, 0, 0,
                                  0, sy, 0,
                                  0, 0, 1 );
      int xi = puntos[0][0];
      int yi = puntos[0][1];
      nuevosPuntos(m);
      int xf = puntos[0][0];
      int yf = puntos[0][1];
      traslacion(xi-xf,yi-yf);
  }

    @Override
    public void keyTyped(KeyEvent e) {
       System.out.println(e.getKeyChar());
       switch (e.getKeyChar()){
        case 'a':
            traslacion(-10, 0);
            repaint(); break;
        case 'd':
            traslacion(10, 0);
            repaint(); break;
        case 'w':
            traslacion(0, -10);
            repaint(); break;
        case 's':
            traslacion(0, 10);
            repaint(); break;
        case 'q':
            rotacion(25);
            repaint(); break;
        case 'e':
            rotacion(-25); 
            repaint(); break;
        case 'i':
            escalamiento(1.1 ,1.1 ); 
            repaint(); break;
        case 'k':
            escalamiento(0.9 , 0.9);
            repaint(); break;
        default: 
            System.out.println("default"); repaint(); break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void leerArchivo(){
        String nombre = "C:\\Users\\estiv\\OneDrive\\Documentos\\NetBeansProjects\\libreria_matematica_y_casita\\src\\libreria_matematica_y_casita\\casita.txt";

        try {
            in = new Scanner(new File(nombre));
            
            // Leer el número de puntos
            String lineString = in.nextLine();
            line = new Scanner(lineString );
            int numPuntos = line.nextInt();
            puntos = new int[numPuntos][2];
            
            
            // Leer los puntos
            for(int punto = 0; punto < numPuntos; punto++) {
                lineString = in.nextLine();
                line = new Scanner(lineString);
                int x = line.nextInt();
                int y = line.nextInt();
                puntos [punto][0]= x + 250;
                puntos [punto][1] = 250 - y;
            }
            
            // Leer el número de puntos
            lineString = in.nextLine();
            line = new Scanner(lineString );
            int numVertices = line.nextInt();
            vertices = new int[numVertices][2];
            
            // Leer los puntos
            for(int vertice = 0; vertice < numVertices; vertice++) {
                lineString = in.nextLine();
                line = new Scanner(lineString);
                vertices[vertice][0] = line.nextInt();
                vertices[vertice][1] = line.nextInt();
               
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo " + nombre + " no se encuentra." + ex);;
        } 
    }
    
    public static void main(String[] args) {        
        
        // Crear un nuevo Frame
      JFrame frame = new JFrame("transformaciones 2d");
      // Al cerrar el frame, termina la ejecución de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      Transformaciones_2d t = new Transformaciones_2d();
      frame.add(t);
      frame.addKeyListener(t);
      // Asignarle tamaño
      frame.setSize(500, 500);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
      
      
    }
    
}
