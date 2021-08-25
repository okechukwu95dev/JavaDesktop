import java.util.*;

public class StudentQuizGrades {

    public static void main(String[] args) {

        int key = 1;
        //userIO interface on left with UserInputOutput core implementation on right
        UserIO userIO = new UserInputOutput();

        //List<Integer> grades = new ArrayList<>();
        Map<String, List<Integer>> studentProfiles = new HashMap<>();

        while (key == 1){

            //display the menu and collect users selection
            String menuPrompt = "Please pick an option:\n1 for View Student List" +
                    "\n2 for Add Student to System \n3 for Remove Student from System" +
                    "\n4 for View List of Quiz Scores \n5 for View Average Quiz Scores \n6 for EXIT";
            int menuSelection = userIO.readInt(menuPrompt,1, 6);

            //view list of students
            if (menuSelection == 1){
                Set<String> studentNames = studentProfiles.keySet();
                for (String student: studentNames){
                    System.out.println(student);
                }
            }

            //add student  to system
            if (menuSelection == 2){
                String userInput = userIO.readString("Enter Student Name: ");

                int addValues = userIO.readInt("Press:\n1 to add student grades \n2 to leave as null");
                if (addValues == 0){
                    studentProfiles.put(userInput,null);
                }
                else if(addValues == 1){
                    int NumberOfScoresToAdd = userIO.readInt("Enter number of grades you will add to list");
                    List<Integer> currentStudentList = new ArrayList<>();
                    for (int i = 0; i < NumberOfScoresToAdd; i++){
                        int currentGrade = userIO.readInt("Please enter a num btw 0 and 100",0,100);
                        currentStudentList.add(currentGrade);
                    }
                    studentProfiles.put(userInput,currentStudentList);
                }
                System.out.println(studentProfiles);
                System.out.println("student added: "+userInput);
            }

            //remove student from the system
            if(menuSelection == 3 ){
                String userInput = userIO.readString("Enter Student Name: ");
                studentProfiles.remove(userInput);
                System.out.println("student removed: "+userInput);
            }

//        list of quiz scores for a given student
            if(menuSelection == 4){
//         ask for specific user
                String userToView = userIO.readString("Whose score would you like to view: ");
                System.out.println( userToView + ":" + studentProfiles.get(userToView));
            }

            if(menuSelection == 5){
                String userToView = userIO.readString("Whose average would you like to view: ");
                List<Integer> currentUserGradesBeingViewed = studentProfiles.get(userToView);
                Integer sum = 0;
                if(!currentUserGradesBeingViewed.isEmpty()) {
                    for (Integer grade : currentUserGradesBeingViewed) {
                        sum += grade;
                    }
                    double average =  sum.doubleValue()/currentUserGradesBeingViewed.size();
                    System.out.println(average);
                }
                else{
                    double average = sum;
                    System.out.println(average);
                }
            }

            if (menuSelection == 6) {
                System.out.println("Thanks for using our student service");
                key = 0;

            }

        }



    }
}
