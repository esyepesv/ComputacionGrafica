/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria_matematica_y_casita;

/**
 *
 * @author estiv
 */
public class Libreria_matematica_y_casita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
    //----------------------------------------------------------------
    
        System.out.println(" matrix 3x3:");
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
            System.out.print(m3.getMatrix()[i][j]+ "  ");
            }
            System.out.println();
        }
        
    //-----------------------------------------------------------------------
       System.out.println(" matrix 4x4:");
       Matrix4x4 m11 = new Matrix4x4(1, 0, 2, 1,
                                    0, 1, 0, 1,
                                    0, 0, 1, 1,
                                    0, 0, 0, 1 );
        
        Point4 p1 = new Point4(3,3,1,2);
        Matrix4x4 m21 = new Matrix4x4(1, 0, 2, 2,
                                     0, 1, 0, 2,
                                     0, 0, 1, 2,
                                     0, 0, 0, 2 );
        
        Point4 mp1 = m11.times(m11, p1);
        System.out.println(mp1.getx());
        System.out.println(mp1.gety());
        System.out.println(mp1.getz());
        System.out.println(mp1.getw());
        
        Matrix4x4 m31 = m11.times(m11,m21);
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
            System.out.print(m31.getMatrix()[i][j]+ "  ");
            }
            System.out.println();
        }
    //------------------------------------------------------------------------\
    
        System.out.println(" vector4:");
        
        Vector4 v41 = new Vector4(1,2,3,4);
        Vector4 v42 = new Vector4(5,6,7,8);
        
        Vector4 pc = v41.crossProduct(v41, v42);
        System.out.println(pc.getx());
        System.out.println(pc.gety());
        System.out.println(pc.getz());
    
        double pp = v41.dotProduct(v41, v42);
        System.out.println(pp);
        
        double m = v41.Magnitude();
        System.out.println(m);
        
        v41.Normalize();
        System.out.println(v41.getx());
        System.out.println(v41.gety());
        System.out.println(v41.getz());
        System.out.println(v41.getw());

    //-------------------------------------------------------------------------
    
    }
    
}
