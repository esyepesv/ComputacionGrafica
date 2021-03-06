/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones_2d;
/**
 *
 * @author estiv
 */
public class Point3 {
    private double x;
    private double y;
    private double w;
    
    public Point3(double x, double y, double w){
        this.x=x;
        this.y=y;
        this.w=w;
    }
    
    public double getx(){
        return x;
    }
    public double gety(){
        return y;
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
    public void setw(double w){
        this.w=w;
    }
}
