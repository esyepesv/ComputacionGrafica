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

public final class Transformaciones_3d extends JPanel
    implements KeyListener {
    
    Scanner in;
    Scanner line;
    int[][] vertices;
    double[][] puntos;
    Line2D.Double linea1;
    
    public Transformaciones_3d() {
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
        double d = -1000;
        for (int[] vertice : vertices) {
            int inicio = vertice[0];
            int fin = vertice[1];
            
            double[] edge1 = puntos[inicio];
            double d1 = edge1[2]/d;
            
            double[] edge2 = puntos[fin];
            double d2 = edge2[2]/d;
            
            linea1.x1 = Math.round(edge1[0]/d1);
            linea1.y1 = Math.round(edge1[1]/d1);
            linea1.x2 = Math.round(edge2[0]/d2);
            linea1.y2 = Math.round(edge2[1]/d2);
            
            g2d.draw(linea1);
        }
  }
  
  public void nuevosPuntos(Matrix4x4 m){
        for (double[] punto : puntos) {
            Point4 p = new Point4(punto[0], punto[1], punto[2], 1);
            p = Matrix4x4.times(m,p);
            punto[0] = p.getx();
            punto[1] = p.gety();
            punto[2] = p.getz();
        }
  }
  
  public void traslacion(double dx, double dy, double dz){
      Matrix4x4 m = new Matrix4x4(1, 0, 0, dx,
                                  0, 1, 0, dy,
                                  0, 0, 1, dz,
                                  0, 0, 0, 1 );
      nuevosPuntos(m);
  }
  
  public void rotacionz(double angulo){
      Matrix4x4 m = new Matrix4x4(Math.cos(angulo), -Math.sin(angulo), 0, 0,
                                  Math.sin(angulo), Math.cos(angulo), 0, 0,
                                  0, 0, 1, 0,
                                  0, 0, 0, 1);
      
      double xi = promedio(0);
      double yi = promedio(1);
      double zi = promedio(2);      
      nuevosPuntos(m);      
      double xf = promedio(0);
      double yf = promedio(1);
      double zf = promedio(2);
      //traslacion inversa
      traslacion(xi-xf, yi-yf, zi-zf);
  }
  
  public void rotacionx(double angulo){
      Matrix4x4 m = new Matrix4x4(1, 0, 0, 0,
                                  0, Math.cos(angulo), -(Math.sin(angulo)), 0,
                                  0, Math.sin(angulo), Math.cos(angulo), 0,
                                  0, 0, 0, 1);
      
      double xi = promedio(0);
      double yi = promedio(1);
      double zi = promedio(2);      
      nuevosPuntos(m);      
      double xf = promedio(0);
      double yf = promedio(1);
      double zf = promedio(2);
      //traslacion inversa
      traslacion(xi-xf, yi-yf, zi-zf);
  }
  
  public void rotaciony(double angulo){
      Matrix4x4 m = new Matrix4x4(Math.cos(angulo), 0, Math.sin(angulo), 0,
                                  0, 1, 0, 0,
                                  -Math.sin(angulo), 0, Math.cos(angulo), 0,
                                  0, 0, 0, 1);
      
      double xi = promedio(0);
      double yi = promedio(1);
      double zi = promedio(2);      
      nuevosPuntos(m);      
      double xf = promedio(0);
      double yf = promedio(1);
      double zf = promedio(2);
      //traslacion inversa
      traslacion(xi-xf, yi-yf, zi-zf);
  }
  
  public void escalamiento(double sx, double sy, double sz){
      Matrix4x4 m = new Matrix4x4(sx, 0, 0, 0,
                                  0, sy, 0, 0,
                                  0, 0, sz, 0,
                                  0, 0, 0, 1);
      
      double xi = promedio(0);
      double yi = promedio(1);
      double zi = promedio(2);      
      nuevosPuntos(m);      
      double xf = promedio(0);
      double yf = promedio(1);
      double zf = promedio(2);
      //traslacion inversa
      traslacion(xi-xf, yi-yf, zi-zf);
  }
  
  // promedio de todos los puntos
  public double promedio(int x){
      double res = 0;
      for(double[] punto : puntos){
          res+=punto[x];
      }
      res/=puntos.length;
      return res;
  }

    @Override
    public void keyTyped(KeyEvent e) {
       switch (e.getKeyChar()){
        case 'a' -> {
            traslacion(-10, 0, 0);
            repaint();
            }
        case 'd' -> {
            traslacion(10, 0, 0);
            repaint();
            }
        case 'w' -> {
            traslacion(0, -10, 0);
            repaint();
            }
        case 's' -> {
            traslacion(0, 10, 0);
            repaint();
            }
        case 'q' -> {
            rotacionz(25);
            repaint();
            }
        case 'e' -> {
            rotacionz(-25);
            repaint();
            }
        case 'r' -> {
            rotacionx(25);
            repaint();
            }
        case 't' -> {
            rotacionx(-25);
            repaint();
            }
        case 'y' -> {
            rotaciony(25);
            repaint();
            }
        case 'u' -> {
            rotaciony(-25);
            repaint();
            }
        case 'i' -> {
            escalamiento(1.1 ,1.1, 1.1 );
            repaint();
            }
        case 'k' -> {
            escalamiento(0.9 , 0.9, 0.9);
            repaint();
            }
        default -> repaint();  
       }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
  public void leerArchivo(){
      String nombre = "C:\\Users\\estiv\\OneDrive\\Documentos\\NetBeansProjects\\transformaciones_3d\\src\\transformaciones_3d\\casita3D.txt";
    
      try {
            in = new Scanner(new File(nombre));
            
            // Leer el número de puntos
            String lineString = in.nextLine();
            line = new Scanner(lineString );
            int numPuntos = line.nextInt();
            puntos = new double[numPuntos][3];
            
            
            // Leer los puntos
            for(int punto = 0; punto < numPuntos; punto++) {
                lineString = in.nextLine();
                line = new Scanner(lineString);
                double x = line.nextDouble();
                double y = line.nextDouble();
                double z = line.nextDouble();
                puntos [punto][0]= x + 250;
                puntos [punto][1] = 250 - y;
                puntos [punto][2] = z;
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
            System.out.println("El archivo " + nombre + " no se encuentra." + ex);
        } 
  
  }
 
  public static void main(String[] args) {
      // Crear un nuevo Frame
      JFrame frame = new JFrame("transformaciones 3d");
      // Al cerrar el frame, termina la ejecución de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      Transformaciones_3d t = new Transformaciones_3d();
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
