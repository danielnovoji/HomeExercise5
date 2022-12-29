import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RealEstate realEstate= new RealEstate();
        int userChoice=0;
        Scanner scanner = new Scanner(System.in);
        while (userChoice!=3) {
        do { System.out.println("Choose your desired option between 1-3: " );
            System.out.println("1. Create a new account.");
            System.out.println("2. Log into an existing account: ");
            System.out.println("3. Exit the program. ");
            userChoice = scanner.nextInt();

        } while (userChoice>3 || userChoice<1);
        switch (userChoice) {
            case Finals.CREATE_ACCOUNT -> realEstate.createUser();
            case Finals.LOGIN_EXISTING_ACCOUNT -> realEstate.login();

        }
        }

        }
    }
