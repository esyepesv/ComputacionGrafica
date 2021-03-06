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
public class Edge {
    private int point1;
    private int point2;
    
    public Edge(int p1, int p2){
        point1=p1;
        point2=p2;
    }
    
    public int getPoint1(){
        return point1;
    }
    public int getPoint2(){
        return point2;
    }
    
    public void setPoint1(int p1){
        point1=p1;
    }
    public void setPoint2(int p2){
        point2=p2;
    }
}
