import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password;
        String exit;
        do {
            System.out.print("Enter password : ");
            password = input.nextLine();

            if (validate(password)) {
                System.out.println("Password valid!");
            }else {
                System.out.println("Password invalid!");
            }

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
    static boolean validate(String password) {
        boolean hasNumber = false, hasUpperCase = false, hasLowerCase = false, hasSpecialChar = false;

        if (password == null || password.length() < 8) {
            System.out.println("Password must be at least 8 characters");
            return false;
        }
        for (char character : password.toCharArray()) {
            if (Character.isDigit(character)) {
                hasNumber = true;
            }
            if (Character.isUpperCase(character)) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(character)) {
                hasLowerCase = true;
            }
            if (!Character.isLetterOrDigit(character) && !Character.isWhitespace(character)) {
                hasSpecialChar = true;
            }
        }
        if(!hasNumber){
            System.out.println("Password must contain number");
        }
        if(!hasUpperCase){
            System.out.println("Password must contain uppercase");
        }
        if(!hasLowerCase){
            System.out.println("Password must contain lowercase");
        }
        if(!hasSpecialChar){
            System.out.println("Password must contain special character");
        }

        return hasNumber && hasUpperCase && hasLowerCase && hasSpecialChar;
    }
}
