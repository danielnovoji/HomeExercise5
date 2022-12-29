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
            case Finals.LOGIN_EXISTING_ACCOUNT -> {
                User user = realEstate.login();
                while (userChoice!=Finals.LOG_OUT_TO_MAIN_MENU){
                if (user==null){
                    userChoice=Finals.LOG_OUT_TO_MAIN_MENU;

                } else {
                    do {
                        System.out.println("""
                            Choose your desired option between 1-6:\s
                            1. Post new property.\s
                            2. Remove a posted property.
                            3. Show all properties.
                            4. Show all properties published by you.
                            5. Search a property by your own defaults.
                            6. Log out and return to the main menu. \s """);
                        userChoice = scanner.nextInt();
                    } while (userChoice<1 || userChoice>6);
                    switch (userChoice) {
                        case Finals.POST_PROPERTY -> {
                            if (realEstate.postNewProperty(user)==true) {
                                System.out.println("The property has been published and saved in the database! ");
                            } else {
                                System.out.println("The property hasn't been published. ");
                            }

                        }
                        case Finals.REMOVE_PROPERTY -> {
                            realEstate.removeProperty(user);

                        }
                        case Finals.PRINT_ALL_PROPERTIES -> {
                            realEstate.printAllProperties();
                        }
                        case Finals.PRINT_YOUR_PROPERTIES -> {
                            realEstate.printProperties(user);
                        }
                        case Finals.SEARCH_BY_DEFAULTS -> {
                            Property [] filterPropertiesArray=realEstate.search();
                            if (filterPropertiesArray!=null){
                            for (int i = 0 ; i < filterPropertiesArray.length;i++){
                                System.out.println(filterPropertiesArray[i]);
                            }}
                        }

                        }

                    }
                }
            }

        } }
        }

        }

