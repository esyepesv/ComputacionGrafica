/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package line.clipping;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author estiv
 */
public class LineClipping_Liang extends JPanel
    implements MouseListener {
    
    Line2D.Double linea1;
    
    public LineClipping_Liang() {
        linea1 = new Line2D.Double();
        this.addMouseListener(this);
    }
      
    @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D) g;
      
      // zona de clipping
      g2d.setColor(Color.BLUE);
      g2d.drawLine(100, 100, 100, 300);
      g2d.drawLine(100, 100, 300, 100);
      g2d.drawLine(300, 100, 300, 300);
      g2d.drawLine(100, 300, 300, 300);
      
     // puntos
     float x1 = (float) linea1.x1;
     float y1 = (float) linea1.y1;
     float x2 = (float) linea1.x2;
     float y2 = (float) linea1.y2;
     
    liang_barsky_clipper(100, 100, 300, 300, x1, y1, x2, y2, g2d);

  }
  
// codigo de: https://en.wikipedia.org/wiki/Liang%E2%80%93Barsky_algorithm
// Liang--Barsky line-clipping algorithm:

// this function gives the maximum
public float maxi(float arr[],int n) {
  float m = 0;
  for (int i = 0; i < n; ++i)
    if (m < arr[i])
      m = arr[i];
  return m;
}

// this function gives the minimum
public float mini(float arr[], int n) {
  float m = 1;
  for (int i = 0; i < n; ++i)
    if (m > arr[i])
      m = arr[i];
  return m;
}

public void liang_barsky_clipper(float xmin, float ymin, float xmax, float ymax,
                          float x1, float y1, float x2, float y2, Graphics2D g2d) {
  // defining variables
  float p1 = -(x2 - x1);
  float p2 = -p1;
  float p3 = -(y2 - y1);
  float p4 = -p3;

  float q1 = x1 - xmin;
  float q2 = xmax - x1;
  float q3 = y1 - ymin;
  float q4 = ymax - y1;

  float[] posarr = new float[5];
  float[] negarr = new float[5];
  int posind = 1, negind = 1;
  posarr[0] = 1;
  negarr[0] = 0;

  if (p1 != 0) {
    float r1 = q1 / p1;
    float r2 = q2 / p2;
    if (p1 < 0) {
      negarr[negind++] = r1; // for negative p1, add it to negative array
      posarr[posind++] = r2; // and add p2 to positive array
    } else {
      negarr[negind++] = r2;
      posarr[posind++] = r1;
    }
  }
  if (p3 != 0) {
    float r3 = q3 / p3;
    float r4 = q4 / p4;
    if (p3 < 0) {
      negarr[negind++] = r3;
      posarr[posind++] = r4;
    } else {
      negarr[negind++] = r4;
      posarr[posind++] = r3;
    }
  }

  float xn1, yn1, xn2, yn2;
  float rn1, rn2;
  rn1 = maxi(negarr, negind); // maximum of negative array
  rn2 = mini(posarr, posind); // minimum of positive array

    // cambio el tipo de dato de los puntos para poder usar el drawLine
    int x10 = (int) x1;
    int y10 = (int) y1;
    int x20 = (int) x2;
    int y20 = (int) y2;
    
  // fuera de la zona de clipping
  if (rn1 > rn2)  { 
   g2d.setColor(Color.red);
   g2d.drawLine(x10, y10, x20, y20);
   return;
  }
  

  xn1 = x1 + p2 * rn1;
  yn1 = y1 + p4 * rn1; // computing new points

  xn2 = x1 + p2 * rn2;
  yn2 = y1 + p4 * rn2;
  
  // cambio el tipo de dato de los puntos para poder usar el drawLine
  int xn10 = (int) xn1;
  int yn10 = (int) yn1;
  int xn20 = (int) xn2;
  int yn20 = (int) yn2;

  g2d.setColor(Color.green);
  g2d.drawLine(xn10, yn10, xn20, yn20); // the drawing the new line

  g2d.setColor(Color.red);
  g2d.drawLine(x10, y10, xn10, yn10);
  g2d.drawLine(x20, y20, xn20, yn20);
}

    @Override 
  public void mouseClicked(MouseEvent e) {}
  
    @Override
  public void mouseEntered(MouseEvent e) {}

    @Override
  public void mouseExited(MouseEvent e) {}

    @Override
  public void mousePressed(MouseEvent e) {
      linea1.x1 = e.getX();
      linea1.y1 = e.getY();
  }

    @Override
  public void mouseReleased(MouseEvent e) {
      linea1.x2 = e.getX();
      linea1.y2 = e.getY();    
      repaint();
  }

  public static void main(String[] args) {
      // Crear un nuevo Frame
      JFrame frame = new JFrame("Eventos del Mouse");
      // Al cerrar el frame, termina la ejecución de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      LineClipping_Liang ev = new LineClipping_Liang();
      frame.add(ev);
      //frame.addMouseListener(ev);
      // Asignarle tamaño
      frame.setSize(500, 500);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
  }

}