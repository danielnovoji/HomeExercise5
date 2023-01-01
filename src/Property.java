public class Property {

    private City city;

    private String street;

    private int roomQuantity;

    private double price;

    private Integer propertyType;

    private boolean isForRent;

    private int houseNumber;

    private int floorNumber;
    private User user;
    public Property(City city, String street, int roomQuantity, double price, Integer propertyType, boolean isForRent, int houseNumber, int floorNumber, User user) { //  O(1)
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
    public boolean propertyTypeValidation (int propertyType) { // O(1)
        boolean isPropertyTypeValid = false;
        if (propertyType >= Finals.APARTMENT && propertyType <= Finals.PRIVATE_HOUSE) {
            isPropertyTypeValid=true;
        }
        return isPropertyTypeValid;

    }
    public User getUser() {
        return this.user;
    } // O(1)

    public String toString () { // O(1)
        String output = "";
        output= "The address of the property: " +"\n" + this.city.getCityName() + "-"  + this.street + " "  + this.houseNumber + "\n" +
                "The property type is: " + this.getPrintPropertyType() + "-" + "For " +
                getPrintPropertyStatus() +": "  +  + this.roomQuantity + " rooms "+"\n" +getPrintFloorNumber() + " "  + "\n" + "Price: " +this.price + "$ " + "\n" + "Contact information: "
                + this.user.getUserName() +" "+
                this.user.getPhoneNumber() + " " + "(" +getUserStatus() + ")";

        return output;

    }
    public String getPrintFloorNumber () { // O(1)
        String floorNumber= "";
        if (this.propertyType==Finals.APARTMENT){
            floorNumber+="Floor " + this.floorNumber;

        }


        return floorNumber;

    }

    public String getPrintPropertyType() { // O(1)
        String propertyType= "";
        switch (this.propertyType) {
            case Finals.PENTHOUSE -> propertyType= "Penthouse";
            case Finals.APARTMENT -> propertyType = "Apartment";
            case Finals.PRIVATE_HOUSE -> propertyType = "Private house";
        } return propertyType;
    }
    private String getPrintPropertyStatus() { // O(1)
        String propertyStatus= "";
        if (this.isForRent == true) {
            propertyStatus = "rent";
        } else {
            propertyStatus= "sale";
        }
        return propertyStatus;
    }
    private String getUserStatus () { // O(1)
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
    } // O(1)

    public Integer getPropertyType() {
        return propertyType;
    } // O(1)



    public float getRoomQuantity() {
        return roomQuantity;
    } // O(1)

    public double getPrice() {
        return price;
    } // O(1)
}