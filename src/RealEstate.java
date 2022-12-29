import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Property[] properties;
    private City[] cities = new City[10];

    public RealEstate() { //CHANGE IT YOU BITCH
        this.cities[0] = new City("Eilat", "Negev-District", "HaTmarim Shachamon Nirit");
        this.cities[1] = new City("Beer-Sheva", "Negev-District", "Bialik Rambam Hatzvi");
        this.cities[2] = new City("Kiryat-Gat", "HaDarom-District", "Hashoftim Tzaal Lachish");
        this.cities[3] = new City("Ashkelon", "HaDarom-District", "Neve-Shalom Rabin Bialik");
        this.cities[4] = new City("Tel-Aviv", "Central-District", "Morozov Dizingof Avital");
        this.cities[5] = new City("Ramat-Gan", "Central-District", "Avigail Einstein Alonim");
        this.cities[6] = new City("Hertzelia", "HaSharon-District", "Marina Kaplan Beeri");
        this.cities[7] = new City("Netanya", "HaSharon-District", "Sokolov Herzel Remez");
        this.cities[8] = new City("Harish", "Northen-District", "Gefen Alon Rimon");
        this.cities[9] = new City("Haifa", "Northen-District", "Oren Hilel Nesher");
    }


    void createUser() {

        Scanner scanner = new Scanner(System.in);
        boolean isExist = true;
        boolean isValid = false;
        String userName="";
        String userPass = "";
        String phoneNumber = "";
            do {
                if (isExist==false){
                    System.out.println("This name is taken, try another name: ");
                }
                System.out.println("Enter a new username: ");
                userName = scanner.nextLine();
                if (users != null) {
                int i;
                for (i = 0; i < users.length; i++) {
                    if (users[i].getUserName().equals(userName)) {
                        isExist = false;
                        break;
                    }
                }
                if (i==users.length){
                    isExist=true;
                } }
            }while (isExist==false);

        while (isValid == false) {
            System.out.println("Enter a valid password: ");
            userPass = scanner.nextLine();
            isValid = passwordValidation(userPass);
            if (isValid == false) {
                System.out.println("Wrong password, please try again: ");
            }


        }
        isValid = false;
        while (isValid == false) {
            System.out.println("Enter a valid phone number(needs to start with 05): ");
            phoneNumber = scanner.nextLine();
            isValid = checkPhoneNumber(phoneNumber);
            if (isValid == false) {
                System.out.println("The number isn't valid, please try again: ");
            }

        }

        System.out.println("Are you a Mediator or a regular user?" + "\n" + "1.Mediator." + "\n" + "2.Regular user.");
        int userStatus = scanner.nextInt();
        boolean isMediator;
        if (userStatus == 1) {
            isMediator = true;
        } else {
            isMediator = false;
        }
        User user = new User(userName, userPass, phoneNumber, isMediator);
        users = insertNewUser(users, user);
    }

    boolean passwordValidation(String userPassword) {
        boolean isValid = true;
        String digits = "0123456789";
        String necessaryChar = "%_$";
        if (userPassword.length() < 5) {
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
        return isValid;
    }

    User[] insertNewUser(User[] users, User user) {
        User[] newUsers;
        if (users != null) {
            newUsers = new User[users.length + Finals.FIRST_NUMBER];
            for (int i = 0; i < users.length; i++) {
                newUsers[i] = users[i];
            }
        }else {
            newUsers = new User[Finals.FIRST_NUMBER];
        }
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
        password = scanner.nextLine();

        if (users != null) {
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUserName()) && password.equals(users[i].getPassword())) ;
                return users[i];
            }
        }
        return null;


    }

    public boolean postNewProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        String cityName;
        String streetName;
        boolean isPropertyPublished = true;
        int counter = 0;
        for (int i = 0; i < properties.length; i++) {
            if (user.getUserName().equals(this.properties[i].getUser().getUserName())) {
                counter++;
            }
        }
        if (user.getIsMediator() == true && Finals.MEDIATOR_PROPERTY_LIMIT == counter) {
            isPropertyPublished = false;
            System.out.println("You've reached your property limit! ");
        } else if (user.getIsMediator() == false && Finals.USER_PROPERTY_LIMIT == counter) {
            isPropertyPublished = false;
            System.out.println("You've reached your property limit! ");
        }
        if (isPropertyPublished == true) {
            System.out.println("The cities are: ");
            for (int i = 0; i < this.cities.length; i++) {
                System.out.println(this.cities[i].getCityName());
            }
            System.out.println("Enter a city from the list above: ");
            cityName = scanner.nextLine();
            boolean isEqualToCityList = false;
            int i;
            for (i = 0; i < this.cities.length; i++) {
                if (cityName.equals(this.cities[i].getCityName())) {
                    isEqualToCityList = true;
                    break;
                }
            }
            if (isEqualToCityList == false) {
                isPropertyPublished = false;
                System.out.println("The name of the city you've typed is invalid.");
            } else {

                System.out.println("The streets in the city are: " + "\n" + this.cities[i].getStreetList());
                System.out.println("Enter a street from the list above: ");
                streetName = scanner.nextLine();
                boolean isEqualToStreetList = false;
                String[] arrayOfStreet = this.cities[i].getStreetList().split(" ");
                for (i = 0; i < arrayOfStreet.length; i++) {
                    if (streetName.equals(arrayOfStreet[i])) {
                        isEqualToStreetList = true;
                        break;

                    }
                }
                if (isEqualToStreetList == false) {
                    System.out.println("The name of the street you've typed is invalid: ");
                    isPropertyPublished = false;
                } else { //COME BACK LATER!

                }


            }
        }
        return isPropertyPublished;
    }

    public void printAllProperties() {
        if (this.properties != null) {
            for (int i = 0; i < this.properties.length; i++) {
                System.out.println("These are the properties that are currently listed: " + properties[i]);

            }

        } else {
            System.out.println("There are currently no properties listed. ");
        }
    }

    void printProperties(User user) {
        boolean isExist = false;
        if (this.properties != null) {
            for (int i = 0; i < this.properties.length; i++) {
                if (user.getUserName().equals(this.properties[i].getUser().getUserName())) {
                    isExist = true;
                    System.out.println("The properties published by you are: " + "\n" + this.properties[i]);
                }
            }
            if (isExist == false) {
                System.out.println("You haven't published any properties.");
            }

        }
    }

    void removeProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean isPublished = false;
        if (this.properties != null) {
            for (int i = 0; i < this.properties.length; i++) {
                if (user.getUserName().equals(this.properties[i].getUser().getUserName())) {
                    isPublished = true;
                }
            }
            if (isPublished == false) {
                System.out.println("You haven't published any properties.");
            } else {
                int [] arrayOfPropertiesIndex;
                int indexChecker=0;
                if (user.getIsMediator()==true){
                    arrayOfPropertiesIndex = new int[Finals.MEDIATOR_PROPERTY_LIMIT];
                } else {
                    arrayOfPropertiesIndex = new int[Finals.USER_PROPERTY_LIMIT];
                }
                for (int i = 0; i < this.properties.length; i++) {
                    if (user.getUserName().equals(this.properties[i].getUser().getUserName())) {
                        System.out.println("The properties are: " + indexChecker+1 + this.properties[i]);
                        arrayOfPropertiesIndex[indexChecker]=i;
                        indexChecker++;

                    }
                }
                boolean isIndexValid=false;
                int propertyRemover;
                do {
                    System.out.println("Please enter the number of the property you want to remove: ");
                    propertyRemover= scanner.nextInt();
                    for (int i = 1; i<arrayOfPropertiesIndex.length;i++){
                        if (arrayOfPropertiesIndex[i] !=0 && propertyRemover == (i)){
                            isIndexValid=true;
                            break;
                        }
                    }
                } while (isIndexValid==false);
                Property [] propertiesArray = new Property[this.properties.length-1];
                int newPropertyArray = 0;
                for (int i = 0 ; i < this.properties.length;i++){
                    if (arrayOfPropertiesIndex[propertyRemover-1]==i){
                        continue;

                    } else {
                        propertiesArray[newPropertyArray]=this.properties[i];
                        newPropertyArray++;
                    }

                }
                this.properties=propertiesArray;
                System.out.println("The property you chose to remove has been removed successfully! ");




            }

        }
    }
    Property [] search () {
        Property [] propertyFilter= new Property[]{};
        Scanner scanner = new Scanner(System.in);
        int saleOrRentChooser;
        boolean isForRent = true;
        System.out.println("Are you interested in a property for sale or rent? " + "\n" + "1.For sale." + "\n" + "2.For rent. ");
        saleOrRentChooser=scanner.nextInt();
        if (saleOrRentChooser==Finals.FOR_SALE){
            isForRent=false;
        } else {
            saleOrRentChooser=Finals.FOR_RENT;
            isForRent=true;
        }
        int roomQuantity;
        int propertySelector;

        System.out.println("""
                What property are you searching for?\s
                1.Apartment.
                2.Penthouse.
                3.Private house.""");

        System.out.println("How many rooms would you like to have? ");


        System.out.println("What is the minimum-maximum price you want?");










        return propertyFilter;
    }
}
