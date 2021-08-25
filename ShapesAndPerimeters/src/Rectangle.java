public class Rectangle extends Shape{

    //variables
    public double length, breadth;

    //constructor
    public Rectangle (double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    //Overridden methods
    @Override
    public double getArea(){

        return length * breadth ;
    }

    @Override
    public double getPerimeter(){
        return (2*length) + (2*breadth);
    }


}
