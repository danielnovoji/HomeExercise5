public class User {
    private String userName;
    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String phoneNumber;
    private boolean isMediator;

    public User(String userName, String password,String phoneNumber,boolean isMediator){
        this.userName=userName;
        if (passwordValidation(password)){
            this.password=password;
        }else {
            this.password=null;
        }
       if (checkPhoneNumber(phoneNumber)){
           this.phoneNumber=phoneNumber;
       }else {
           this.phoneNumber=null;
       }

        this.isMediator=isMediator;
    }

    public String getUserName() {
        return this.userName;
    }
    public String toString () {
        String output="";
        output += "The new user is: " + this.userName + "Password: " + this.password + "Phone number: " + this.phoneNumber + "Mediator/regular user: " + isMediator;

        return output;
    }
    public String getPassword () {
        return this.password;
    }
    public boolean getIsMediator () {
        return this.isMediator;
    }
    public boolean passwordValidation(String userPassword) {
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

    public boolean checkPhoneNumber(String phoneNumber) {
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

}
