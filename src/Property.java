public class Property {

    private City city;

    private String street;

    private float roomQuantity;

    private double price;

    private Integer propertyType;

    private boolean isForRent;

    private int houseNumber;

    private int floorNumber;
    private User user;
    public Property(City city, String street, float roomQuantity, double price, Integer propertyType, boolean isForRent, int houseNumber, int floorNumber, User user) {
        this.city = city;
        this.street = street;
        this.roomQuantity = roomQuantity;
        this.price = price;
        if (propertyTypeValidation(propertyType)){
            this.propertyType = propertyType;
        } else {
            this.propertyType = null;
        }
        this.isForRent = isForRent;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.user = user;

    }
    public boolean propertyTypeValidation (int propertyType) {
        boolean isPropertyTypeValid = false;
        if (propertyType >= Finals.APARTMENT && propertyType <= Finals.PRIVATE_HOUSE) {
            isPropertyTypeValid=true;
        }
        return isPropertyTypeValid;

    }
    public User getUser() {
        return this.user;
    }

    public String toString () {
        String output = "";
        output += "The address of the property: " + this.city + "-" + this.street + " " + this.houseNumber + "\n";
        output += "The property type is: " + this.getPrintPropertyType() + "-";
        output += "For" + getPrintPropertyStatus() + ":";
        output += this.roomQuantity + "rooms,";
        output += "floor" + this.floorNumber + "\n";
        output += "Price: " + this.price + "$";
        output += "Contact info: " + this.user.getUserName()+ this.user.getPhoneNumber() + "(" + getUserStatus() + ")";
        return output;

    }

    public String getPrintPropertyType() {
        String propertyType= "";
        switch (this.propertyType) {
            case Finals.PENTHOUSE -> propertyType= "Penthouse";
            case Finals.APARTMENT -> propertyType = "Apartment";
            case Finals.PRIVATE_HOUSE -> propertyType = "Private house";
        } return propertyType;
    }
    private String getPrintPropertyStatus() {
        String propertyStatus= "";
        if (this.isForRent == true) {
            propertyStatus = "rent";
        } else {
            propertyStatus= "sale";
        }
        return propertyStatus;
    }
    private String getUserStatus () {
        String userStatus = "";
        if (this.user.getIsMediator() == true){
            userStatus = "real estate broker";
        } else {
            userStatus = "Regular user";
        }
        return userStatus;
    }
    public boolean getIsForRent() {
        return isForRent;
    }

    public Integer getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }

    public float getRoomQuantity() {
        return roomQuantity;
    }

    public double getPrice() {
        return price;
    }
}