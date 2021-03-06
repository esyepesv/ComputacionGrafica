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
public class Vector4 {
    private double x;
    private double y;
    private double z;
    private double w;
    
    public Vector4(double x, double y, double z, double w){
        this.x=x;
        this.y=y;
        this.z=z;
        this.w=w;
    }
    
    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }
    public double getz(){
        return z;
    }
    public double getw(){
        return w;
    }
    
    public void setx(double x){
        this.x=x;
    }
    public void sety(double y){
        this.y=y;
    }
    public void setz(double z){
        this.z=z;
    }
    public void setw(double w){
        this.w=w;
    }
    
    public static Vector4 crossProduct(Vector4 v1, Vector4 v2){
        
        Vector4 res = new Vector4(0,0,0,0);
        
        // X(v1y*v2z - v1z*v2y) - Y(v1x*v2z - v1z*v2x) + Z(v1x*v2y - v1y*v2x)
        res.setx((v1.gety() * v2.getz()) - (v1.getz() * v2.gety()));
        res.sety(-((v1.getx() * v2.getz()) - (v1.getz() * v2.getx())));
        res.setz((v1.getx() * v2.gety()) - (v1.gety() * v2.getx()));

        return res;
    }
    
    public static double dotProduct(Vector4 v1, Vector4 v2){
        
        double res = 0;
        
        res += v1.getx()*v2.getx();
        res += v1.gety()*v2.gety();
        res += v1.getz()*v2.getz();
        res += v1.getw()*v2.getw();
        
        return res;
    }
    
    public double Magnitude(){
        
        double r = Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2) + Math.pow(this.w,2);
        
        double mag = Math.sqrt(r);
        
        return mag;
    }
    
    public void Normalize(){
        
        double mag = Magnitude();
        
        this.x=this.x/mag;
        this.y=this.y/mag;
        this.z=this.z/mag;
        this.w=this.w/mag;
        
    }
    
    
}
