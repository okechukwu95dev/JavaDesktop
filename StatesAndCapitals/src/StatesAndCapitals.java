import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatesAndCapitals {

    public static void main(String[] args) {

            Map<String, String> names = new HashMap<>();
            names.put("Alabama","Montgomery");
            names.put("Alaska","Juneau");
            names.put("Arizona","Phoenix");
            names.put("Arkansas","Little Rock");

            //pritn state names
            Set<String> stateNames = names.keySet();
            for(String currentState : stateNames ){
                System.out.println(currentState);
            }

//           print capital names
            Collection<String> capitalNames = names.values();
            for (String capital : capitalNames){
                System.out.println(capital);
            }

//            printkeys and values
            for (String name: stateNames){
                String capital = names.get(name);
                System.out.println("State: "+ name+ " Capital: " + capital);
            }

        }

}
