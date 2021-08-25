import java.lang.Math;

public class Circle extends Shape{

    //variables
    public double radius;

    //constructors
    public Circle (double radius){
        this.radius = radius;
    }

    //overridden inherited methods
    @Override
    public double getArea(){
        return 3.14* radius* radius;
    }

    @Override
    public double getPerimeter(){
        return 3.14*2*radius;
    }


}
