import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Property[] properties;
    private City[] cities;

    void createUser() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a new username: ");
        String userName = scanner.nextLine();
        boolean isExist = true;
        boolean isValid = false;
        String userPass = "";
        String phoneNumber = "";
        if (users!=null){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUserName().equals(userName)) {
                isExist = false;
                break;
            }
        }}
        while (isValid == false) {
            System.out.println("Enter a valid password: ");
            userPass = scanner.nextLine();
            isValid = passwordValidation(userPass);


        }
        isValid = false;
        while (isValid == false) {
            System.out.println("Enter a valid phone number(needs to start with 05): ");
            phoneNumber = scanner.nextLine();
            isValid = checkPhoneNumber(phoneNumber);
        }

        System.out.println("Are you a Mediator or a regular user?" + "\n"  + "1.Mediator." + "\n" + "2.Regular user.");
        int userStatus = scanner.nextInt();
        boolean isMediator;
        if (userStatus == 1) {
            isMediator = true;
        } else {
            isMediator = false;
        }
        User user = new User(userName, userPass, phoneNumber, isMediator);
        users = insertNewUser(users, user);
        System.out.println(users[0]);

    }

    boolean passwordValidation(String userPassword) {
        boolean isValid = true;
        String digits = "0123456789";
        String necessaryChar = "%_$";
        if (userPassword.length() != 5) {
            isValid = false;
        }
        if (isValid == true) {
            isValid = false;
            for (int i = 0; i < userPassword.length(); i++) {
                String currentChar = userPassword.charAt(i) + "";
                if (digits.contains(currentChar) == true) {
                    isValid = true;
                    break;
                }
            }
        }
        if (isValid == false) {
            System.out.println("Wrong password, please try again: ");
        }
        return isValid;

    }

    boolean checkPhoneNumber(String phoneNumber) {
        boolean isValid = true;
        String numbers = "0123456789";
        if (phoneNumber.length() != 10) {
            isValid = false;
        } else {
            String digits = phoneNumber.substring(0, 2);
            if (digits.equals("05")) {
                for (int i = 2; i < phoneNumber.length(); i++) {
                    String checker = phoneNumber.charAt(i) + "";
                    if (numbers.contains(checker) == false) {
                        isValid = false;

                    }
                }
            }
        }
        if (isValid == false)
            System.out.println("The number isn't valid, please try again: ");
        return isValid;
    }

    User[] insertNewUser(User[] users, User user) {
        Finals final1 = new Finals();
        User[] newUsers;
        if (users!=null){
        newUsers = new User[users.length + final1.FIRST_NUMBER];
        for (int i = 0; i < users.length; i++) {
            newUsers[i] = users[i];
        }}
        newUsers = new User[final1.FIRST_NUMBER];
        newUsers[newUsers.length - 1] = user;
        return newUsers;
    }

    public User login() {

        String username;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        username = scanner.nextLine();
        System.out.println("Enter your password: ");
        password=scanner.nextLine();

        if (users != null) {
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUserName()) && password.equals(users[i].getPassword())) ;
                return users[i];
            }
        }
            return null;


        }
        public boolean postNewProperty(User user) {
        boolean isPropertyPublished = false;
        int mediatorCounter = 0;
        int regularUserCounter = 0;
        for (int i=0; i < properties.length; i++){
            if (user.getMediator)
            if(user.getUserName().equals(properties[i].getUserName()));


        }
            return isPropertyPublished;
        }

}
