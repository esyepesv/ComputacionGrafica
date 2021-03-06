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
public class Matrix3x3 {
    
    private double[][] matrix = new double[3][3];
    
    public Matrix3x3(double x11,double x12, double x13,
                     double x21,double x22,double x23, 
                     double x31,double x32,double x33){
        matrix[0][0] = x11;
        matrix[0][1] = x12;
        matrix[0][2] = x13;
        matrix[1][0] = x21;
        matrix[1][1] = x22;
        matrix[1][2] = x23;
        matrix[2][0] = x31;
        matrix[2][1] = x32;
        matrix[2][2] = x33;  
    }
    
    public double[][] getMatrix(){
        return matrix;
    }
    
    public void setMatrix(double[][] matrix){
        this.matrix = matrix;
    }
    
    public static Point3 times(Matrix3x3 matrix, Point3 p){
        Point3 r = new Point3(0,0,0);
        double[][] m = matrix.getMatrix();
       
        double x = 0;
        x += m[0][0] * p.getx();
        x += m[0][1] * p.gety();
        x += m[0][2] * p.getw();
        r.setx(x);
        
        double y = 0;
        y += m[1][0] * p.getx();
        y += m[1][1] * p.gety();
        y += m[1][2] * p.getw();
        r.sety(y);
        
        double w = 0;
        w += m[2][0] * p.getx();
        w += m[2][1] * p.gety();
        w += m[2][2] * p.getw();
        r.setw(w);
            
        return r;
    }
    
    public static Matrix3x3 times(Matrix3x3 m1, Matrix3x3 m2){
        Matrix3x3 m3 = new Matrix3x3(0, 0, 0, 0, 0, 0, 0, 0, 0);
        double[][] m = m3.getMatrix();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    m[i][j] += m1.getMatrix()[i][k] * m2.getMatrix()[k][j];
                }
            }
        }
        m3.setMatrix(m);
        return m3;
    }
}
