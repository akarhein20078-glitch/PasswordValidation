import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password;
        String exit;
        do {
            System.out.print("Enter password : ");
            password = input.nextLine();

            validate(password);

            do {
                System.out.print("Do you want to continue (y/n) : ");
                exit = input.nextLine();

                if (exit.equalsIgnoreCase("y") || exit.equalsIgnoreCase("yes") || exit.equalsIgnoreCase("n") || exit.equalsIgnoreCase("no")){
                    break;
                }else {
                    System.out.println("Invalid option!");
                }
            }while(true);
            if(exit.equalsIgnoreCase("n") || exit.equalsIgnoreCase("no")) break;
        }while(true);
        input.close();
    }

    //validate method
    static void validate(String password) {

        if(password.length() < 8) System.out.println("Password must be at least 8 characters!");
        else {
            if (!password.matches(".*[A-Z].*")) System.out.println("Password must contain uppercase!");
            if (!password.matches(".*[a-z].*")) System.out.println("Password must contain lowercase!");
            if (!password.matches(".*\\d.*")) System.out.println("Password must contain number!");
            if (!password.matches(".*[!@#$%&*?].*")) System.out.println("Password must contain special character!");
            if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\d])(?=.*[!@#$%&*?]).{8,}$")) System.out.println("Password valid");
        }
    }
}
