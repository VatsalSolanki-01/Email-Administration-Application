import java.util.ArrayList;
import java.util.Scanner;
public class EmailApp {
    static Scanner sc= new Scanner(System.in);
    static ArrayList<Email> emailList = new ArrayList<>();

    public static boolean doesIdExist(int id){
        boolean result = false;
        for(int i=0;i<emailList.size();i++){
            if(id==emailList.get(i).getId()){
                result = true;
                break;
            }
            else{
                result = false;
            }
        }
        return result;
    }
    public static void menu(){
        loop : while(true){
            System.out.println("!!! WELCOME TO EMAIL GENERATING APPLICATION HERE ARE THE OPTIONS :- ");
            System.out.println("1 - ENTER DETAILS OF NEW EMPLOYEE AND GENERATE EMAIL ADDRESS ");
            System.out.println("2 - READ ALL THE EMPLOYEE EMAIL ADDRESS RECORDS");
            System.out.println("3 - UPDATE EMAIL ADDRESS OF EMPLOYEE ");
            System.out.println("4 - DELETE EMPLOYEE ADDRESS ");
            System.out.println("5 - TO EXIT THE APPLICATION ");
            int input=sc.nextInt();
            switch (input) {
                case 1:
                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    break loop;
                default:
                    System.out.println("enter valid input");
                    break;
            }
        }
    }
    
    public static void create(){
        System.out.print("enter Employee id :- ");
        int id=sc.nextInt();
        while(doesIdExist(id)!=false){
            System.out.println("this id already exists enter another one :- ");
            id=sc.nextInt();
        }
        sc.nextLine();
        System.out.print("enter Employee first name :-");
        String firstname = sc.next();
        System.out.print("enter Employee lastname :-");
        String lastname = sc.next();
        System.out.print("enter Employee department :-");
        String department = sc.next();
        emailList.add(new Email(id,firstname,lastname,department));
    }

    public static void read(){
        for(int i=0;i<emailList.size();i++){
            System.out.println("record no :- "+i);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println( " Name ~ "+emailList.get(i).getFirstName()+emailList.get(i).getLasttName()+" Employee id ~ "+emailList.get(i).getId()+" Email Address ~ "+emailList.get(i).getEmail());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }


    public static void update(){
        System.out.println("enter Employee id :- ");
        Integer id=sc.nextInt();
        System.out.println("enter 1 to update Firstname :- ");
        System.out.println("enter 2 to update lastname :- ");
        System.out.println("enter 3 to update department :- ");
        System.out.println("enter 4 to update password :- ");
        int input=sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("enter new First Name of employee :- ");
                String newFirstName=sc.next();
                for(int i =0;i<emailList.size();i++){
                    if(id.equals(emailList.get(i).getId())){
                        emailList.get(i).setFirstName(newFirstName);
                    }
                }
                for(int i=0;i<emailList.size();i++){
                    if(id.equals(emailList.get(i).getId())){
                        String newEmail=newFirstName.toLowerCase()+"."+emailList.get(i).getLasttName().toLowerCase()+"@"+emailList.get(i).getDepartment()+"."+
                        emailList.get(i).getCOMPANYNAME()+".com";
                        emailList.get(i).setEmailAddress(newEmail);
                    }
                }
                break;
            case 2:
                System.out.println("enter new Last Name of employee :- ");
                String newLastName=sc.next();
                for(int i =0;i<emailList.size();i++){
                    if(id.equals(emailList.get(i).getId())){
                        emailList.get(i).setLastName(newLastName);
                    }
                }
                for(int i=0;i<emailList.size();i++){
                    if(id.equals(emailList.get(i).getId())){
                        String newEmail=emailList.get(i).getFirstName().toLowerCase()+"."+newLastName.toLowerCase()+"@"+emailList.get(i).getDepartment()+"."+
                        emailList.get(i).getCOMPANYNAME()+".com";
                        emailList.get(i).setEmailAddress(newEmail);
                    }
                }
            case 3:
                System.out.println("enter new Department of employee :- ");
                String newDepartment=sc.next();
                for(int i =0;i<emailList.size();i++){
                    if(id.equals(emailList.get(i).getId())){
                        emailList.get(i).setDepartment(newDepartment);
                    }
                }
                for(int i=0;i<emailList.size();i++){
                    if(id.equals(emailList.get(i).getId())){
                        String newEmail=emailList.get(i).getFirstName().toLowerCase()+"."+emailList.get(i).getLasttName().toLowerCase()+"@"+newDepartment+"."+
                        emailList.get(i).getCOMPANYNAME()+".com";
                        emailList.get(i).setEmailAddress(newEmail);
                    }
                }
                break;
            case 4:
                for(int i=0;i<emailList.size();i++){
                    if(id.equals(emailList.get(i).getId())){
                        emailList.get(i).setPass();
                    }
                }
                break;
            case 5:
                System.out.println("enter any 1 input from above given !!!");
                break;
            default:
                break;
        }
    }
    public static void delete(){
        System.out.println("enter Employee id to remove the employee :- ");
        Integer id=sc.nextInt();
        for(int i =0;i<emailList.size();i++){
            if(id.equals(emailList.get(i).getId())){
                emailList.remove(i);
            }
        }
    }
    public static void main(String[] args) {
        menu();
    }
}
