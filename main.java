// Things to do before Running the code
//Create database lms
import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;

public class main {
    public static void main(String[] args) {

        //  Header

        System.out.println("************************************************************************************************************************");
        System.out.println("                                         Welcome to Library Management System");
        System.out.println("************************************************************************************************************************");
        System.out.println("                                         Created by Anuj Shandilya");
        System.out.println("************************************************************************************************************************");
        System.out.println("************************************************************************************************************************");

        //Get into the account

        System.out.println("Hey,");
        System.out.println();
        System.out.println("Welcome to the Anuj's Library Management System.");
        System.out.println();
        System.out.println("Enter 0 for Creating a new L.M.S Acoount.");
        System.out.println("Enter 1 for Logging into your L.M.S Acoount.");
        System.out.println("Enter 2 for Recovering your L.M.S Acoount if forgotten.");
        System.out.println("Enter 3 for Deleting your L.M.S Acoount.");

        System.out.println("************************************************************************************************************************");
        System.out.println("************************************************************************************************************************");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the key to choose: ");
        int key=sc.nextInt();
                

        // Clear the Screen
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 

        //Welcoming to the portal
        System.out.println("************************************************************************************************************************");
        System.out.println("************************************************************************************************************************");
        if(key==0){
            System.out.println("                                         Welcome for the Registration.");

        }else if(key==1){
            System.out.println("                                         Welcome to your Account.");

        }else if(key==2){
            System.out.println("                                         Enter the correct details to recover.");

        }else if(key==3){
            System.out.println("                                         Think Again before deleting.");

        }else{
            System.out.println("                                         Press the correct key.");

        }
        System.out.println("************************************************************************************************************************");
        System.out.println("************************************************************************************************************************");

        //condition for keys
        createLMSAccount newAc = new createLMSAccount();

        switch (key) {
            case 0: //For creating an account

            //TAke Details
                System.out.print("Enter your name: ");
                newAc.name = sc.next();
                System.out.print("Enter your email: ");
                newAc.email = sc.next();
                System.out.print("Enter Username for your Account: ");
                newAc.setuserName(sc.next());
                // Verify user name if already exists
                System.out.print("Enter your company name: "); 
                newAc.companyName = sc.next();
                System.out.print("Enter your mobile number (last 2 digits): ");
                newAc.Mobile = sc.nextInt();  
                
            //Create Account

                newAc.createAccount();
                newAc.createAccountantDatabase();
                newAc.createtable();
                newAc.createBooklist();
                newAc.createcheckinlist();
                newAc.createcheckOUTlist();
                String pressanyKey = sc.next();
                break;
            case 1:
            //For logging in in the data

            //Take details
            LoggingIN li = new LoggingIN();
            //Enter to your Account
            System.out.print("Enter your username:");
            String username = sc.next();
            li.username = username;
            System.out.print("Enter last two digit Mob:");
            li.mob=sc.nextInt();


            // verify details
            if(li.verification()==true){
                // Clear the Screen
                 System.out.print("\033[H\033[2J");  
                 System.out.flush();

                 // Welcoming
                 System.out.println("************************************************************************************************************************");
                 System.out.println("************************************************************************************************************************");
                 System.out.println("                                         Welcome to your Account!!");
                 System.out.println("************************************************************************************************************************");
                 System.out.println("************************************************************************************************************************");
                 
                 // Ask for option to join
                 System.out.println("Enter 0 for See list of Books.");
                 System.out.println("Enter 1 for Register Student.");
                 System.out.println("Enter 2 for List of Registered Student");
                 System.out.println("Enter 3 for CheckIn Book.");
                 System.out.println("Enter 4 for Checkout Book.");
                 System.out.println("Enter 5 for Show Book Issued by the Student");
                 System.out.println("Enter 6 for Delete Student data.");
                 System.out.println("Enter any key for Log out");

                 System.out.println("************************************************************************************************************************");
                 System.out.println("************************************************************************************************************************");
                 System.out.print("Enter your choice: ");
                 int choice = sc.nextInt();
                 System.out.println("************************************************************************************************************************");
                 System.out.println("************************************************************************************************************************");

                 if(choice == 0){

                    //for booklist
                    ListOFbooks lb = new ListOFbooks();
                    lb.username = username;
                    lb.ListOfbooks();
                
                 }else if(choice == 1){

                    // For Registering Student

                    RegisteringStudent rs = new RegisteringStudent();
                    rs.username = username;
                    System.out.print("Enter the Student Reg no.: ");
                    rs.sid = sc.nextInt();
                    System.out.print("Enter the Student name: ");
                    rs.sname = sc.next();
                    System.out.print("Enter the Student Branch: ");
                    rs.sbranch = sc.next();

                    rs.Registeringstudent();

                 }else if(choice == 2){

                    //List of Registered Students

                    regstudentlist rgl = new regstudentlist();
                    rgl.username = username;
                    rgl.Registeredslist();

                 }else if(choice == 3){

                    // For check in of the book

                    // verification of registered student
                    checkIN ci = new checkIN();
                    ci.username = username;
                    System.out.print("Enter the Registration number of the student:");
                    ci.Regno = sc.nextInt();
                    System.out.print("Enter the branch of the student: ");
                    ci.branch = sc.next();
                    if(ci.verification()==true){
                        System.out.print("Enter the book id: ");
                        ci.bookid = sc.nextInt();
                        System.out.print("Enter the book name: ");
                        ci.bookname = sc.next();
                        ci.checkin();
                    }else{
                        System.out.println("Student id not registered.");
                        break;
                    }


                 }else if(choice==4){
                    // For check out of the book

                    // verification of registered student
                    checkOUT co = new checkOUT();
                    co.username = username;
                    System.out.print("Enter the Registration number of the student:");
                    co.Regno = sc.nextInt();
                    System.out.print("Enter the branch of the student: ");
                    co.branch = sc.next();
                    if(co.verification()==true){
                        System.out.print("Enter the book id: ");
                        co.bookid = sc.nextInt();
                        System.out.print("Enter the book name: ");
                        co.bookname = sc.next();
                        co.checkout();
                        co.checkinremoval();

                    }else{
                        System.out.println("Student id not registered.");
                        break;
                    }
                 }else if(choice==5){
                    //Show checkin
                    showcheckin sci = new showcheckin();
                     // verification of registered student
                     
                     sci.username = username;
                     System.out.print("Enter the Registration number of the student:");
                     sci.Regno = sc.nextInt();
                     System.out.print("Enter the branch of the student: ");
                     sci.branch = sc.next();
                     if(sci.verification()==true){
                        sci.showlist();
 
                     }else{
                         System.out.println("Student id not registered.");
                         break;
                     }
                 }else if(choice == 6){
                    //del
                    delStudent ds = new delStudent();
                    ds.username = username;

                    //verification
                   
                     System.out.print("Enter the Registration number of the student:");
                     ds.Regno = sc.nextInt();
                     System.out.print("Enter the branch of the student: ");
                     ds.branch = sc.next();
                     if(ds.verification()==true){
                        ds.del();
                     }else{
                         System.out.println("Student id not registered.");
                         break;
                     }
                    
                 }else{
                    break;
                 }

                break;
            }else{
                System.out.println("Details is not correct");
                break;
            }


            case 2:
            //Recovering your Account
                     recover_account ra = new recover_account();
                     System.out.print("Enter the Name of the Account holder:");
                     ra.name = sc.next();
                     System.out.print("Enter the Company Name of the Account holder: ");
                     ra.company = sc.next();
                     System.out.print("Enter the Email of the Account holder: ");
                     ra.email = sc.next();
                     if(ra.verification()==true){
                        ra.showlist();
                     }else{
                         System.out.println("Account is not registered.");
                         break;
                     }

            break;

            case 3:
                     //Delete your Account

                     DelAct dd = new DelAct();
                     System.out.print("Enter your username: ");
                     dd.username = sc.next();
                     System.out.print("Enter your last two digit mobile no: ");
                     dd.mob = sc.nextInt();

                     if(dd.verification()==true) { 
                         System.out.println("Are you sure?\n It will delete all the data that cannot be recovered!!");
                         System.out.println("Enter 1 for yes.\nEnter 2 for No.");
                         int ch = sc.nextInt();
                         if(ch==1){
                            dd.deldatabase();
                            dd.deldata();
                         }
                     }
                     break;

            default:
            System.out.println("Enter the appropriate option");
               // throw new AssertionError();
        }
        

    }
}
