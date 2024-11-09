import java.util.Random;
import java.util.Scanner;

public class Email{
    static Scanner sc =new Scanner(System.in);
    private final String COMPANYNAME ="SOLTechSolutions";
    private String firstname;
    private String lastname;
    private String department;
    private String Password = generatePass();
    private String emailAddress;

    Email(String firstname,String lastname,String department){
        this.firstname=firstname;
        this.lastname=lastname;
        this.department=department;
        emailAddress=firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department+"."+
        COMPANYNAME+".com";
    }

    public void setFirstName(String firstname){
        this.firstname=firstname;
    }

    public String getFirstName(){
        return this.firstname;
    }

    public void setLastName(String lastname){
        this.lastname=lastname;
    }

    public String getLasttName(){
        return this.lastname;
    }
    
    public void setDepartment(String department){
        this.department=department;
    }

    public String getDepartment(){
        return this.department;
    }

    public String getEmail(){
        return this.emailAddress;
    }

    private String generatePass(){ // to generate random 8 characters of password.
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$&*";

    StringBuilder sb = new StringBuilder();
    Random random = new Random();

    for(int i = 0; i < 8; i++) {

      int index = random.nextInt(alphabet.length());
      char randomChar = alphabet.charAt(index);
      sb.append(randomChar);
    }
    String randomString = sb.toString();
    return randomString;
    }

    public void setPass(){ // to set the new password by the employee himself.
        System.out.println("enter a strong password :- ");
        String pass1 = sc.next();
        System.out.println("re-enter the new password :- ");
        String pass2 = sc.next();
        if(pass1.equals(pass2)){
            Password = pass1;
            System.out.println("password set successfully");    
        }else{
            System.out.println("it seems like both the passwords dont match redo the process");
            setPass();
        }
    }
    private String getPass(){
        return this.Password;
    }
    public void getInfo(){
        System.out.println("***********************************");
        System.out.println("heyy... "+firstname);
        System.out.println("your professional email address is :-"+this.getEmail());
        System.out.println("and password for your emal address is :- "+this.getPass());
        System.out.println("***********************************");
    }
}