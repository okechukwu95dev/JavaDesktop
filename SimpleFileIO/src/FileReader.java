import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(new BufferedReader(new java.io.FileReader("MoreStateCapitals.txt")));

        //we use a while loop here incase there are none of it hthere is a lot of them
        //check if scanner has next line
        while(sc.hasNextLine()){
            String currentLine = sc.nextLine();
            String[] currentLineArray = currentLine.split("::");
//            key = currentLineArray[0];
//            value = Capial.name = currentLineArray[1];
//             value = capital.population = curentLineArray[2];
//             value = capital.squaremileage = currentLineaRRAY[3];
//
//
//
//
//             JUUU


//            System.out.println(currentLineArray);
            System.out.println(Arrays.toString(currentLineArray));

        }

//        String string = "004-034556";
//        String[] parts = string.split("-");
//        String part1 = parts[0]; // 004
//        String part2 = parts[1]; // 034556
//
//        System.out.println("done");

    }

}
