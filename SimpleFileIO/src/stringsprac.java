public class stringsprac {
    public static void main(String[] args) {

        String s = "abc";
        String result = "";
//        int i = 0;
//        while (i < s.length()){
//            char c = s.charAt(i);
//            result = result + c + c;
//            i++;
//        }

        for (int i= 0; i < s.length(); i++){
            char c = s.charAt(i);
            result = result + c + c;

        }
        System.out.println(result);
        }
    }

