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
public class LineClipping_Cohen extends JPanel
    implements MouseListener {
    
    Line2D.Double linea1;
    
    public LineClipping_Cohen() {
        linea1 = new Line2D.Double();
        this.addMouseListener(this);
    }
     public int INSIDE = 0; // 0000
     public int LEFT = 1;   // 0001
     public int RIGHT = 2;  // 0010
     public int BOTTOM = 4; // 0100
     public int TOP = 8;    // 1000
     
     public int xmin = 100;
     public int ymin = 100;
     public int xmax = 300;
     public int ymax = 300;
      

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
     int x0 = (int) linea1.x1;
     int y0 = (int) linea1.y1;
     int x1 = (int) linea1.x2;
     int y1 = (int) linea1.y2;
     
    CohenSutherlandLineClipAndDraw(x0, y0, x1, y1, g2d);

  }
  
 
  // codigo de: https://en.wikipedia.org/wiki/Cohen%E2%80%93Sutherland_algorithm
  public void CohenSutherlandLineClipAndDraw(int x0, int y0, int x1, int y1, Graphics2D g2d){
        int outcode0 = ComputeOutCode(x0, y0);
	int outcode1 = ComputeOutCode(x1, y1);
	
    //while(true){
        if ((outcode0 | outcode1) == 0){
            g2d.setColor(Color.GREEN);
            g2d.drawLine(x0, y0, x1, y1);
	} 
        else if ((outcode0 & outcode1) != 0) {
            g2d.setColor(Color.RED);
            g2d.drawLine(x0, y0, x1, y1);
	}
        else{
            
            int x, y;
            x = y = 0;            

            int outcodeOut = outcode1 > outcode0 ? outcode1 : outcode0;

            if ((outcodeOut & TOP) !=0 ) {           // point is above the clip window
		x = x0 + (x1 - x0) * (ymax - y0) / (y1 - y0);
		y = ymax;
                
            } else if ((outcodeOut & BOTTOM) !=0 ) { // point is below the clip window
		x = x0 + (x1 - x0) * (ymin - y0) / (y1 - y0);
		y = ymin;
                
            } else if ((outcodeOut & RIGHT)!=0) {  // point is to the right of clip window
		y = y0 + (y1 - y0) * (xmax - x0) / (x1 - x0);
		x = xmax;
                
            } else if ((outcodeOut & LEFT)!=0) {   // point is to the left of clip window
		y = y0 + (y1 - y0) * (xmin - x0) / (x1 - x0);
		x = xmin;
            }
            
            if (outcodeOut == outcode0) {
		x0 = x;
		y0 = y;
		outcode0 = ComputeOutCode(x0, y0);
            } else {
		x1 = x;
		y1 = y;
		outcode1 = ComputeOutCode(x1, y1);
            }
            
        } 
    //}
  
  }
  
  public int ComputeOutCode(int x, int y){
	int code;

	code = INSIDE;          // initialised as being inside of [[clip window]]

	if (x < xmin)           // to the left of clip window
		code |= LEFT;
	else if (x > xmax)      // to the right of clip window
		code |= RIGHT;
	if (y < ymin)           // below the clip window
		code |= BOTTOM;
	else if (y > ymax)      // above the clip window
		code |= TOP;

	return code;
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
      LineClipping_Cohen ev = new LineClipping_Cohen();
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