import java.util.Scanner;
public class WindowMaster {

    public static void main(String [] args){

        //declare variables for height and width
        String  windowHeight;
        String  windowWidth;
        float height;
        float width;

        float windowArea;
        float windowPerimeter;
        float cost;

        //initialise a new scanner as myScanner
        Scanner myScanner = new Scanner(System.in);

        //ask users for input of height and width
        System.out.println("Please enter height for window ");
        windowHeight = myScanner.nextLine();
        System.out.println("Please enter width for window ");
        windowWidth  = myScanner.nextLine();

        //Convert height and width to integers
        height = Float.parseFloat(windowHeight);
        width = Float.parseFloat(windowWidth);

        windowArea = height * width;
        windowPerimeter = 2*(height+width);

        cost = (windowArea*3.50f)+(windowPerimeter*2.50f);

        System.out.println("THE COST IS "+ cost);










    }
}
