/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4.cg;

/**
 *
 * @author estiv
 */
public class Clase4CG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Matrix3x3 m1 = new Matrix3x3(1, 0, 2,
                                     0, 1, 0,
                                     0, 0, 1);
        
        Point3 p = new Point3(3,3,1);
        Matrix3x3 m2 = new Matrix3x3(1, 0, 1,
                                     0, 1, 0,
                                     0, 0, 1);
        
        Point3 mp = m1.times(m1, p);
        System.out.println(mp.getx());
        System.out.println(mp.gety());
        System.out.println(mp.getw());
        
        Matrix3x3 m3 = m1.times(m1,m2);
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
            System.out.print(m3.matrix[i][j]+ "  ");
            }
            System.out.println();
        }
        
    }
    
}
