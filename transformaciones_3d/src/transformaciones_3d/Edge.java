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
public class Edge {
    private double point1;
    private double point2;
    private double z;
    
    public Edge(double p1, double p2, double z){
        point1=p1;
        point2=p2;
        this.z=z;
    }
    
    public double getPoint1(){
        return point1;
    }
    public double getPoint2(){
        return point2;
    }
    public double getz(){
        return z;
    }
    
    public void setPoint1(double p1){
        point1=p1;
    }
    public void setPoint2(double p2){
        point2=p2;
    }
}
