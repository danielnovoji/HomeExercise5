public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private boolean isMediator;

    public User(String userName, String password,String phoneNumber,boolean isMediator){
       this.userName=userName;
       this.password=password;
       this.phoneNumber=phoneNumber;
       this.isMediator=isMediator;
    }

    String getUserName() {
        return this.userName;
    }
    public String toString () {
        String output="";
        output += "The new user is: " + this.userName + "Password: " + this.password + "Phone number: " + this.phoneNumber + "Mediator/regular user: " + isMediator;

        return output;
    }
    String getPassword () {
        return this.password;
    }
    String getIsMediator () {
        return this.isMediator;
    }


}
