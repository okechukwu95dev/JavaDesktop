import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleFileIO {

    public static void main(String[] args) throws Exception {

        //just like scanner object
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

        out.println("This is me writing to a file for the first time");
        out.println("This is me writing to a file for the second time");
        out.flush();//to make DOUBLE SURE we've written to file
        out.close();//closing os really important

//        reading from a file requires a buffer or file reader // why do we need a buffer reader i
        Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));

        //we use a while loop here incase there are none of it hthere is a lot of them
        //check if scanner has next line
        while(sc.hasNextLine()){
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }

        System.out.println("done");






    }
}
