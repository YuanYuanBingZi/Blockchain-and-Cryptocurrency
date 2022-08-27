package model1;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String emailRegex = "^(.+)@(.+).(.+)$";
    private Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email) throws IllegalAccessException{

        if (!pattern.matcher(email).matches()){
            throw new IllegalAccessException("Error, Invalid email");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String  getEmail(){
        return email;
    }

    @Override
    public String toString(){

        return "Firstname: " + firstName
                + " Lastname: " + lastName
                + " Email: " + email;
    }
}
