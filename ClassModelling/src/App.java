import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        int selection = 0;
        Scanner sc = new Scanner(System.in);

        //Calculate
        while (selection < 5){

            //ask for selections
            System.out.println("Please select an option from below:\n1 " +
                    "for addition\n2 for subtraction \n3 for multiplication" +
                    " \n4 for division\n5 for exit");
            //parse selections
            selection = Integer.parseInt(sc.nextLine());
            if (selection == 5){
                System.out.println("thanks for playing");
                break ;
            }
            //Collect users Operands
            System.out.println("Please enter  first option ");
            int operandOne = Integer.parseInt(sc.nextLine());
            System.out.println("Please enter second option ");
            int operandTwo = Integer.parseInt(sc.nextLine());

            switch(selection) {
                case 1 :
                    System.out.println(SimpleCalculator.add(operandOne,operandTwo));
                    break;
                case 2 :
                    System.out.println(SimpleCalculator.subtract(operandOne,operandTwo));
                    break;
                case 3 :
                    System.out.println(SimpleCalculator.multiply(operandOne,operandTwo));
                    break;
                case 4:
                    System.out.println(SimpleCalculator.divide(operandOne,operandTwo));
                    break;
            }
        }
    }
}
