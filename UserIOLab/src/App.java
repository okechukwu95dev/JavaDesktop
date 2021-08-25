

public class App {

    public static void main(String[] args) {

//        using userIO interface
        UserIO userIO = new UserInputOutput();


        int selection = 0;


        //Calculate
        while (selection < 5){

            //ask for selections
            String beginGamePrompt = "Please select an option from below:\n1 " +
                    "for addition\n2 for subtraction \n3 for multiplication" +
                    " \n4 for division\n5 for exit";
            //parse selections
            selection  = userIO.readInt(beginGamePrompt, 1, 5);


            if (selection == 5){
                System.out.println("thanks for playing");
                break ;
            }
            //Collect users Operands
            int operandOne = userIO.readInt("Please enter the first option");
            int operandTwo = userIO.readInt("Please enter the second option");

            switch(selection) {
                case 1 :
                    System.out.println(SimpleCalculatorRefactored.add(operandOne,operandTwo));
                    break;
                case 2 :
                    System.out.println(SimpleCalculatorRefactored.subtract(operandOne,operandTwo));
                    break;
                case 3 :
                    System.out.println(SimpleCalculatorRefactored.multiply(operandOne,operandTwo));
                    break;
                case 4:
                    System.out.println(SimpleCalculatorRefactored.divide(operandOne,operandTwo));
                    break;
            }
        }
    }
}
