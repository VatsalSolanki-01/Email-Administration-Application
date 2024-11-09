import java.util.Scanner;
public class EmailApp {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("enter your first name :-");
        String firstname = sc.next();
        System.out.print("enter your lastname :-");
        String lastname = sc.next();
        System.out.print("enter your department :-");
        String department = sc.next();
        Email employee1 = new Email(firstname,lastname,department);
        employee1.getInfo();
        System.out.print("enter y if your want to change password and n if you dont want to change it :- ");
        char input = sc.next().charAt(0);
        if(input=='y'){
            employee1.setPass();
        }
        else{
            System.out.println("enjoy your work...!!!");
        }
    }
}
