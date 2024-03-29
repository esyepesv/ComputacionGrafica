
/**
 * Clase para dibujar algunos puntos.
 * 
 * @author Helmuth Trefftz
 * @version Septiembre 2016
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JFrame;
    
public class Puntos extends JPanel
{

    @Override
  public void paintComponent(Graphics g) {
      //super.paintComponent(g);

      Graphics2D g2d = (Graphics2D) g;

      g2d.setColor(Color.blue);
      /*
      // Dibujar unos puntos.
      g2d.drawLine(10, 10, 10, 10);
      g2d.drawLine(20, 20, 20, 20);
      g2d.drawLine(30, 30, 30, 30);
      g2d.drawLine(40, 40, 40, 40);
      */
      
      //Dibujar un segmento de recta desde el punto <10,10> hasta el punto <310,360>
      
      int x1 = 10;
      int y1 = 10;
      int x2 = 310;
      int y2 = 360;
      
      int dx = x2-x1;
      int dy = y2-y1;
      int d = 2*dy - dx;
      int y = y1;
      
      for(int x = x1; x<dx; x++){
          // putpixel(x,y);
          g2d.drawLine(x, y, x, y);
          if(d<=0){
          d = d + 2*dy;
          }
          else{
          y++;
          d = d - 2*dx;
          }
      }
  }
 
 

  public static void main(String[] args) {
      // Crear un nuevo Frame
      JFrame frame = new JFrame("Puntos");
      // Al cerrar el frame, termina la ejecución de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Agregar un JPanel que se llama Points (esta clase)
      frame.add(new Puntos());
      // Asignarle tamaño
      frame.setSize(500, 500);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
  }
    
}
