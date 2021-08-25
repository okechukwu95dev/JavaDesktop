public class Square extends Shape {

    //define variables
    private double length;


    //define constructor
     public Square (double length){
         this.length = length;
    }


    @Override
    public double getPerimeter(){
        return  4 * length;

    };

    @Override
    public double getArea(){
        return length*length;
    }




}