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
public class Matrix4x4 {
    private double[][] matrix = new double[4][4];
    
    public Matrix4x4(double x11, double x12, double x13, double x14,
                     double x21, double x22, double x23, double x24, 
                     double x31, double x32, double x33, double x34,
                     double x41, double x42, double x43, double x44){
        matrix[0][0] = x11;
        matrix[0][1] = x12;
        matrix[0][2] = x13;
        matrix[0][3] = x14;
        matrix[1][0] = x21;
        matrix[1][1] = x22;
        matrix[1][2] = x23;
        matrix[1][3] = x24;
        matrix[2][0] = x31;
        matrix[2][1] = x32;
        matrix[2][2] = x33;
        matrix[2][3] = x34;
        matrix[3][0] = x41;
        matrix[3][1] = x42;
        matrix[3][2] = x43;
        matrix[3][3] = x44;
    }
    
    public double[][] getMatrix(){
        return matrix;
    }
    
    public void setMatrix(double[][] matrix){
        this.matrix = matrix;
    }
    
    public static Point4 times(Matrix4x4 matrix, Point4 p){
        Point4 r = new Point4(0,0,0,0);
        double[][] m = matrix.getMatrix();
        
        double x = 0;
        x += m[0][0] * p.getx();
        x += m[0][1] * p.gety();
        x += m[0][2] * p.getz();
        x += m[0][3] * p.getw();
        r.setx(x);
        
        double y = 0;
        y += m[1][0] * p.getx();
        y += m[1][1] * p.gety();
        y += m[1][2] * p.getz();
        y += m[1][3] * p.getw();
        r.sety(y);
        
        double z = 0;
        z += m[2][0] * p.getx();
        z += m[2][1] * p.gety();
        z += m[2][2] * p.getz();
        z += m[2][3] * p.getw();
        r.setz(z);
        
        double w = 0;
        w += m[3][0] * p.getx();
        w += m[3][1] * p.gety();
        w += m[3][2] * p.getz();
        w += m[3][3] * p.getw();
        r.setw(w);
            
        return r;
    }
    
    public static Matrix4x4 times(Matrix4x4 m1, Matrix4x4 m2){
        Matrix4x4 m3 = new Matrix4x4(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        double[][] m = m3.getMatrix();
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    m[i][j] += m1.getMatrix()[i][k] * m2.getMatrix()[k][j];
                }
            }
        }
        m3.setMatrix(m);
        return m3;
    }
}
