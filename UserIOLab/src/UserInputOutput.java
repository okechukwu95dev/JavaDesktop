import java.util.Scanner;

public class UserInputOutput implements UserIO{

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);

    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String response = sc.nextLine();
        return response;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int response = Integer.parseInt(sc.nextLine());
        return response;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int response = 0 ;
        do {
            System.out.println(prompt);
            response = Integer.parseInt(sc.nextLine());

        }while (response < min || response > max);
        return response;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double response = Double.parseDouble(sc.nextLine());
        return response;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double response = 0.0 ;
        do {
            System.out.println(prompt);
            response = Double.parseDouble(sc.nextLine());

        }while (response < min || response > max);
        return response;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float response = Float.parseFloat(sc.nextLine());
        return response;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float response = 0.0f;
        do {
            System.out.println(prompt);
            response = Float.parseFloat(sc.nextLine());

        }while (response < min || response > max);
        return response;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long response = Long.parseLong(sc.nextLine());
        return response;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long response = 0;
        do {
            System.out.println(prompt);
            response = Long.parseLong(sc.nextLine());

        }while (response < min || response > max);
        return response;
    }
}
