public class Property {

    private City city;
    private String street;
    private int roomQuantity;
    private int price;
    private int propertyType;
    private boolean isForRent;
    private int houseNumber;
    private int floorNumber;
    private User user;


    User getUser() {
        return this.user;
    }
    public String toString () {
        String output = "";
        output += "The address of the property: " + this.city + "-" + this.street + " " + this.houseNumber + "\n";
        output += "The property type is: " + this.getPropertyType() + "-";
        output += "For" + getPropertyStatus() + ":";
        output += this.roomQuantity + "rooms,";
        output += "floor" + this.floorNumber + "\n";
        output += "Price: " + this.price + "$";
        output += "Contact info: " + this.user + user.getPhoneNumber() + "(" + getUserStatus() + ")";
        return output;

    }
    public String getPropertyType () {
        String propertyType= "";
        switch (this.propertyType) {
            case Finals.PENTHOUSE -> propertyType= "Penthouse";
            case Finals.APARTMENT -> propertyType = "Apartment";
            case Finals.PRIVATE_HOUSE -> propertyType = "Private house";
        } return propertyType;
    }
    private String getPropertyStatus () {
        String propertyStatus= "";
        if (isForRent = true) {
            propertyStatus = "rent";
        } else {
            propertyStatus= "sale";
        }
        return propertyStatus;
    }
    private String getUserStatus () {
        String userStatus = "";
        if (user.getIsMediator() == true){
            userStatus = "real estate broker";
        } else {
            userStatus = "Regular user";
        }
        return userStatus;
    }

}