import java.lang.Math;

public class Triangle extends Shape {
    //define variables
    private double sideA,sideB,sideC;


    //define constructor
    public Triangle (double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }


    @Override
    public double getPerimeter(){
        return  sideA + sideB + sideC  ;
    };

    @Override
    public double getArea(){

        //using HEORN'S FORMULA
        double p = (sideA + sideB + sideC)/2;

        return Math.pow(p * (p-sideA) * (p-sideB)* (p-sideC),0.5);
//        return length**2;
    }


}