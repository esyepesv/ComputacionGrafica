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
public class Point4 {
    private double x;
    private double y;
    private double z;
    private double w;
    
    public Point4(double x, double y, double z, double w){
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
}
