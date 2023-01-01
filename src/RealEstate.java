import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Property[] properties;
    private City[] cities = new City[10];

    public RealEstate() { // O(1)
        this.cities[0] = new City("Arad", "Negev-District", "Anafa Ankor Hasida");
        this.cities[1] = new City("Beer-Sheva", "Negev-District", "Yosiyahu Bnei-Or Kafrisin");
        this.cities[2] = new City("Sderot", "HaDarom-District", "Nizsan Arazim Herzog ");
        this.cities[3] = new City("Ashkelon", "HaDarom-District", "Lakhish Rashi Tsahal");
        this.cities[4] = new City("Bat-Yam", "Central-District", "Rabi-Binyamin Brenner Keren-HaYesod");
        this.cities[5] = new City("Holon", "Central-District", "Mota-Gur Imber Motskin");
        this.cities[6] = new City("Ramat-HaSharon", "HaSharon-District", "Mordehai Rambam Tavor");
        this.cities[7] = new City("Kfar-Saba", "HaSharon-District", "Jerusalem Yehuda Pinkas");
        this.cities[8] = new City("Nesher", "Northen-District", "Perets Eshkolot Dukhifat");
        this.cities[9] = new City("Acre", "Northen-District", "Gad Shimon Reuven");
    }


    public void createUser() { // O(n)

        Scanner scanner = new Scanner(System.in);
        boolean isExist = true;
        boolean isValid = false;
        String userName = "";
        String userPass = "";
        String phoneNumber = "";
        do {
            if (isExist == false) {
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
                if (i == users.length) {
                    isExist = true;
                }
            }
        } while (isExist == false);

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

        System.out.println("""
                Are you a Mediator or a regular user?
                1.Mediator.
                2.Regular user.""");
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

    private boolean passwordValidation(String userPassword) { // O(n)
        boolean isValidPass = true;
        String digits = "0123456789";
        String necessaryChar = "%_$";
        if (userPassword.length() < 5) {
            isValidPass = false;
        }
        if (isValidPass == true) {
            isValidPass = false;
            for (int i = 0; i < userPassword.length(); i++) {
                String currentChar = userPassword.charAt(i) + "";
                if (digits.contains(currentChar) == true) {
                    isValidPass = true;
                    break;
                }
            }
        }
        return isValidPass;

    }

    private boolean checkPhoneNumber(String phoneNumber) { // O(n)
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

    private User[] insertNewUser(User[] users, User user) { // O(n)
        User[] newUsers;
        if (users != null) {
            newUsers = new User[users.length + Finals.FIRST_NUMBER];
            for (int i = 0; i < users.length; i++) {
                newUsers[i] = users[i];
            }
        } else {
            newUsers = new User[Finals.FIRST_NUMBER];
        }
        newUsers[newUsers.length - 1] = user;

        return newUsers;
    }

    public User login() { // O(n)

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

    public boolean postNewProperty(User user) { // O(n)
        Scanner scanner = new Scanner(System.in);
        String cityName;
        City chosenCity;
        String streetName;
        int propertyType;
        int floor = 0;
        int roomQuantity;
        int houseNumber;
        boolean isForRent;
        double price;
        int saleOrRent;
        boolean isPropertyPublished = true;
        int counter = 0;
        if (this.properties!=null){
        for (int i = 0; i < this.properties.length; i++) {
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
        }}
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
                } else {
                    chosenCity = new City(cityName, this.cities[i].getGeographicDistrict(), streetName);

                    System.out.println("""
                            What type of property you want to publish? \s
                            1.Apartment.
                            2.Penthouse.
                            3.Private house.\s""");
                    propertyType = scanner.nextInt();
                    if (propertyType >= 1 && propertyType <= 3) {
                    if (propertyType==Finals.APARTMENT){
                        do {

                            System.out.println("Which floor is the apartment located? ");
                            floor= scanner.nextInt();
                        } while (floor<-1);

                    }
                    do {
                        System.out.println("How many rooms are in the property? ");
                        roomQuantity=scanner.nextInt();
                    }while ((roomQuantity % 1 != 0.5 && roomQuantity % 1 != 0));
                    do {
                        System.out.println("What is the house number of the property? ");
                        houseNumber= scanner.nextInt();
                    } while (houseNumber<0);
                    do {
                        System.out.println("Is the property for sale or rent? \n 1. Sale. \n 2. Rent");
                        saleOrRent= scanner.nextInt();
                    } while (saleOrRent<1 || saleOrRent>2);
                    if (saleOrRent==Finals.FOR_SALE){
                        isForRent=false;
                    } else {
                        isForRent=true;
                    }

                    do {
                        System.out.println("What is the price of the property you want to publish? ");
                        price=scanner.nextDouble();
                    }while (price<0);

                    Property publishedProperty = new Property(chosenCity, streetName, roomQuantity, price, propertyType, isForRent, houseNumber, floor, user);
                        Property [] publishedPropertiesArray;
                    if (this.properties!=null){
                    publishedPropertiesArray = new Property[this.properties.length+Finals.FIRST_NUMBER];
                    for (int j = 0 ; j < this.properties.length; j++){
                        publishedPropertiesArray[j]= this.properties[j];
                    }} else { publishedPropertiesArray=new Property[Finals.FIRST_NUMBER];

                    }
                    publishedPropertiesArray[publishedPropertiesArray.length-Finals.FIRST_NUMBER]=publishedProperty;
                        this.properties=publishedPropertiesArray;

                    } else {
                        System.out.println("The option you chose is invalid. ");
                        isPropertyPublished = false;
                    }

                }
            }
        }
        return isPropertyPublished;
    }

    public void printAllProperties() { // O(n)
        if (this.properties != null) {
            for (int i = 0; i < this.properties.length; i++) {
                System.out.println("These are the properties that are currently listed: " + properties[i]);

            }
        } else {
            System.out.println("There are currently no properties listed. ");
        }
    }

    public void printProperties(User user) { // O(1) or O(n).
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

    public void removeProperty(User user) { // O(n)
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
                int[] arrayOfPropertiesIndex;
                int indexChecker = 0;
                if (user.getIsMediator() == true) {
                    arrayOfPropertiesIndex = new int[Finals.MEDIATOR_PROPERTY_LIMIT];
                } else {
                    arrayOfPropertiesIndex = new int[Finals.USER_PROPERTY_LIMIT];
                }
                for (int i = 0; i < this.properties.length; i++) {
                    if (user.getUserName().equals(this.properties[i].getUser().getUserName())) {
                        System.out.println("The properties are: " + (indexChecker + 1) + this.properties[i]);
                        arrayOfPropertiesIndex[indexChecker] = i;
                        indexChecker++;

                    }
                }
                boolean isIndexValid = false;
                int propertyRemover;
                do {
                    System.out.println("Please enter the number of the property you want to remove: ");
                    propertyRemover = scanner.nextInt();
                    for (int i = 0; i < arrayOfPropertiesIndex.length; i++) {
                        if (propertyRemover == (i)) {
                            isIndexValid = true;
                            break;
                        }
                    }
                } while (isIndexValid == false);
                Property[] propertiesArray = new Property[this.properties.length - 1];
                int newPropertyArray = 0;
                for (int i = 0; i < this.properties.length; i++) {
                    if (arrayOfPropertiesIndex[propertyRemover - Finals.FIRST_NUMBER] == i) {
                        continue;

                    } else {
                        propertiesArray[newPropertyArray] = this.properties[i];
                        newPropertyArray++;
                    }

                }
                this.properties = propertiesArray;
                System.out.println("The property you chose to remove has been removed successfully! ");


            }

        } else {
            System.out.println("There are no properties to remove. ");
        }
    }

    public Property[] search() { // O(n)
        Property[] propertyFilterArray;
        Scanner scanner = new Scanner(System.in);
        int saleOrRentChooser;
        boolean isForRent = true;

        do {
            System.out.println("""
                    Are you interested in a property for sale or rent?\s
                    1.For sale.
                    2.For rent.\s""");
            saleOrRentChooser = scanner.nextInt();
        } while ((saleOrRentChooser < Finals.FIRST_NUMBER || saleOrRentChooser > Finals.SECOND_NUMBER) && (saleOrRentChooser != Finals.NEUTRAL_CHOICE));
        if (saleOrRentChooser == Finals.FOR_SALE) {
            isForRent = false;
        }
        int propertySelector;
        do {
            System.out.println("""
                    What property are you searching for?\s
                    1.Apartment.
                    2.Penthouse.
                    3.Private house.\s""");
            propertySelector = scanner.nextInt();
        } while ((propertySelector < Finals.FIRST_NUMBER || propertySelector > Finals.THIRD_NUMBER) && (propertySelector !=Finals.NEUTRAL_CHOICE));
        float roomQuantity;
        boolean isValidRoomQuantity = true;
        do {
            System.out.println("How many rooms would you like to have? ");
            roomQuantity = scanner.nextFloat();
            if (isValidRoomQuantity == false) {
                System.out.println("Please try again! (Whole number.) ");
            }
            isValidRoomQuantity = false;
        } while ((roomQuantity != Finals.NEUTRAL_CHOICE) && (roomQuantity < 1));
        double minimumPrice;
        double maximumPrice;
        boolean isValidMinimumPrice = true;
        boolean isValidMaximumPrice = true;
        do {
            System.out.println("What is the minimum price you want? ");
            minimumPrice = scanner.nextDouble();
            if (isValidMinimumPrice == false) {
                System.out.println("The number you entered is below 0, please try again! ");
            }
            isValidMinimumPrice = false;

        } while ((minimumPrice < 0) && (minimumPrice != Finals.NEUTRAL_CHOICE));
        do {
            System.out.println("What is the maximum price you want? ");
            maximumPrice = scanner.nextDouble();
            if (isValidMaximumPrice == false) {
                System.out.println("The number you entered is lower than your minimum price! try again.");
            }
            isValidMaximumPrice = false;
        } while (maximumPrice < minimumPrice && maximumPrice != Finals.NEUTRAL_CHOICE);

        int propertyFilterCounter = 0;
        for (int i = 0 ; i < this.properties.length; i++){
            if (propertySearchFilter(saleOrRentChooser, isForRent, propertySelector, roomQuantity, minimumPrice, maximumPrice, i)==true){
                propertyFilterCounter++;
        }
        }
        propertyFilterArray = new Property[propertyFilterCounter];
        int indexOfPropertyFilterArray=0;
        for (int i = 0; i < this.properties.length; i++){
            if (propertySearchFilter(saleOrRentChooser, isForRent, propertySelector, roomQuantity, minimumPrice, maximumPrice, i)==true){
                propertyFilterArray[indexOfPropertyFilterArray]=this.properties[i];
                indexOfPropertyFilterArray++;

            }
        }
            return propertyFilterArray;
    }


    public boolean propertySearchFilter(int saleOrRentChooser, boolean isForRent, int propertySelector, float roomQuantity, double minimumPrice, double maximumPrice, int index) { // O(n)
        boolean isValidFilter = false;
        if (saleOrRentChooser != Finals.NEUTRAL_CHOICE) {
            if (isForRent == this.properties[index].getIsForRent()) {
                isValidFilter = true;
            }
        } else {
            isValidFilter=true;
        }
        if (isValidFilter == true) {
            if (propertySelector != Finals.NEUTRAL_CHOICE) {
                if (propertySelector == this.properties[index].getPropertyType()) {
                    isValidFilter = true;
                } else {
                    isValidFilter = false;
                }
            } else {
                isValidFilter=true;
            }
            if (isValidFilter == true) {
                if (roomQuantity != Finals.NEUTRAL_CHOICE) {
                    if (roomQuantity == this.properties[index].getRoomQuantity()) {
                        isValidFilter = true;
                    } else {
                        isValidFilter = false;
                    }
                } else {
                    isValidFilter=true;
                }
                if (isValidFilter == true) {
                    if (minimumPrice != Finals.NEUTRAL_CHOICE) {
                        if (minimumPrice <= this.properties[index].getPrice()) {
                            isValidFilter = true;
                        } else {
                            isValidFilter = false;
                        }
                    } else {
                        isValidFilter=true;
                    }
                    if (isValidFilter = true) {
                        if (maximumPrice != Finals.NEUTRAL_CHOICE) {
                            if (maximumPrice >= this.properties[index].getPrice()) {
                                isValidFilter = true;
                            } else {
                                isValidFilter = false;
                            }
                        }
                    } else {
                        isValidFilter=true;
                    }
                }
            }
        }

        return isValidFilter;
    }
}


