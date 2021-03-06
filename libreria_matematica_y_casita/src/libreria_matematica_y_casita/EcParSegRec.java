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
public class EcParSegRec {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    
    public EcParSegRec(double x1, double y1, double x2, double y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    
    public double getx1(){
        return x1;
    }
    public double gety1(){
        return y1;
    }
    public double getx2(){
        return x2;
    }
    public double gety2(){
        return y2;
    }
    
    public void setx1(double x1){
        this.x1=x1;
    }
    public void sety1(double y1){
        this.y1=y1;
    }
    public void setx2(double x2){
        this.x2=x2;
    }
    public void sety2(double y2){
        this.y2=y2;
    }
    
    public static double[] solve(EcParSegRec epsr1, EcParSegRec epsr2){
        double[] res = new double[2];        
        /*
        x = x1 + t(x2-x1)
        y = y1 + t(y2-y1)
        */
        
        double u1; // x = epsr1.getx1() + u1*(epsr1.getx2()-epsr1.getx1())
                   // y = epsr1.gety1() + u1*(epsr1.gety2()-epsr1.gety1())
                   
        double u2; // x = epsr2.getx1() + u2*(epsr2.getx2()-epsr2.getx1())
                   // y = epsr2.gety1() + u2*(epsr2.gety2()-epsr2.gety1())
        
        /* igualando x y y:
                   
        u1*(epsr1.getx2()-epsr1.getx1()) - u2*(epsr2.getx2()-epsr2.getx1()) = epsr2.getx1() - epsr1.getx1()
        u1*(epsr1.gety2()-epsr1.gety1()) - u2*(epsr2.gety2()-epsr2.gety1()) = epsr2.gety1() - epsr1.gety1()       
                   
         */
        
        return res;
    }
    
}
