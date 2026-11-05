import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password;
        String exit;
        do {
            System.out.print("Enter password : ");
            password = input.nextLine();

            if(validate(password)){
                System.out.println("Password valid!");
            }else {
                System.out.println("Password invalid!");
            }

            do {
                System.out.print("Do you want to continue (y/n) : ");
                exit = input.nextLine();

                if (exit.matches("(?i)^(y|n|yes|no)$")){
                    break;
                }else {
                    System.out.println("Invalid option!");
                }
            }while(true);
            if(exit.matches("(?i)^(n|no)$")) break;
        }while(true);
        input.close();
    }

    //validate method
    static boolean validate(String password) {

        if(password == null || password.length() < 8) {
            System.out.println("Password must be at least 8 characters!");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) System.out.println("Password must contain uppercase!");
        if (!password.matches(".*[a-z].*")) System.out.println("Password must contain lowercase!");
        if (!password.matches(".*\\d.*")) System.out.println("Password must contain number!");
        if (!password.matches(".*[!@#$%&*?].*")) System.out.println("Password must contain special character!");

        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\d])(?=.*[!@#$%&*?])(?=\\S{8,}).*$");
    }
}
