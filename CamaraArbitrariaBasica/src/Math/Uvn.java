/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

/**
 *
 * @author htrefftz
 */
public class Uvn extends Matrix4x4  {
    Vector4 from;
    Vector4 lookAt;
    Vector4 up;

    public Uvn() {
        super();
    }
    
    public Uvn(Vector4 from, Vector4 lookAt, Vector4 up) {
        // For the time being, create an identity matrix
        super();
        
        Vector4 n = Vector4.subtract(from, lookAt);
        n.normalize();
        
        Vector4 u = Vector4.crossProduct(up, n);
        u.normalize();
        
        Vector4 v = Vector4.crossProduct(n, u);
        
        matrix[0][0] = u.getX();
        matrix[0][1] = u.getY();
        matrix[0][2] = u.getZ();
        matrix[0][3] = -(Vector4.dotProduct(u, from));
        
        matrix[1][0] = v.getX();
        matrix[1][1] = v.getY();
        matrix[1][2] = v.getZ();
        matrix[1][3] = -(Vector4.dotProduct(v, from));
        
        matrix[2][0] = n.getX();
        matrix[2][1] = n.getY();
        matrix[2][2] = n.getZ();
        matrix[2][3] = -(Vector4.dotProduct(n, from));
        
        matrix[3][0] = 0;
        matrix[3][1] = 0;
        matrix[3][2] = 0;
        matrix[3][3] = 1;
        
     
        
    }
    
    
}
