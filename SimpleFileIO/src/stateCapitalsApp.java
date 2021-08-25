import java.util.*;
import java.io.BufferedReader;

public class stateCapitalsApp {

    public static void main (String[] args) throws Exception {

        //DECLARE MAP [STRING KEY = [CAPITAL.NAME, CAPITAL.POP, CAPITAL.SQ-MILEAGE]
        Map<String,Capital> statesAndCapitalsCollections = new HashMap<>();

        //INITIALISE FILE SCANNER WITH BUFFERED READER
        Scanner sc = new Scanner(new BufferedReader(new java.io.FileReader("MoreStateCapitals.txt")));

        //READ FILE LINE BY LINE
        while(sc.hasNextLine()){//WHILE NEXT-LINE IS NOT EMPTY
            String currentLine = sc.nextLine();//SAVE SCANNED INFO AS STRING CURRENT-LINE
            String[] currentLineArray = currentLine.split("::");//SPLIT INPUT INTO ARRAY

            //VARIABLES TO STORE THE INDIVIDUAL FIELDS
            String currentStateName = currentLineArray[0];
            String currentCapitalName = currentLineArray[1];
            double currentPopulation = Double.parseDouble(currentLineArray[2]);
            double currentSquareMileage = Double.parseDouble(currentLineArray[3]);

            //Instantiate new capital object
            Capital currentCapital = new Capital(currentCapitalName,currentPopulation,currentSquareMileage);
            statesAndCapitalsCollections.put(currentStateName,currentCapital);
        }

        //PRINT OUT MESSAGE OF NUMBER OF HASH MAP OBJECTS
        System.out.println("We have " + statesAndCapitalsCollections.size() + " objects in our hash map ");

        //PRINT OUT EACH STATE AND ITS CAPITAL OBJECT TO THE SCREEN
        Set<String> allStates = statesAndCapitalsCollections.keySet();//keySet CONTAINING UNIQUE KEYS

        for (String state : allStates){
            Capital temp = statesAndCapitalsCollections.get(state);
                printTarget(state, temp);
        }

        //ASK USER FOR POPULATION LIMIT and PRINT ONLY POPULATION LIMITS
        Scanner userInputPop = new Scanner(System.in);
        System.out.println("Enter lower bound for population: ");
        double populationLimit = Double.parseDouble(userInputPop.nextLine());
        for (String state : allStates){
            Capital temp = statesAndCapitalsCollections.get(state);
            if (statesAndCapitalsCollections.get(state).population > populationLimit){
                printTarget(state, temp);
            }
        }

        //ASK USER FOR AREA LIMIT AND PRINT ONLY AREA LIMITS FOR STATES AND CAPITALS
        Scanner userInputArea = new Scanner(System.in);
        System.out.println("Enter upper bound for Area: ");
        double AreaLimit = Double.parseDouble(userInputArea.nextLine());
        for (String state : allStates){
            Capital temp = statesAndCapitalsCollections.get(state);
            if (statesAndCapitalsCollections.get(state).squareMileage < AreaLimit){
                printTarget(state, temp);
            }
        }
    }

    public static void printTarget(String item, Capital temp)
    {
        System.out.println("State: "+ item +
                "\nCapital: " + temp.name+
                "\nPopulation: "+ temp.population+"" +
                "\nSquare Mileage: "+ temp.squareMileage+"\n\n");
    }
}
