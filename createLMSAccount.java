//crceate table in the lms data base having account name


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class createLMSAccount {
    public String name;
    public String companyName;
    private String username;
    public int Mobile;
    public String email;


    //set username
    public void setuserName(String username){
        this.username = username;
    }


    //get username
    public void getuserName(){
        System.out.println(this.username);
    }

    public void createAccount(){
        try {
            String url = "jdbc:mysql://localhost:3306/lms";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url, userName, password);
                String Querry = "insert  into accounts values (?,?,?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(Querry);
				pstm.setString(1,this.name);
                pstm.setString(2,this.username);
                pstm.setString(3,this.companyName);
                pstm.setInt(4, this.Mobile);
                pstm.setString(5, email);
				
				pstm.executeUpdate();
                System.out.println("Successfully Created!!");
                System.out.println("************************************************************************************************************************");
                System.out.println("************************************************************************************************************************");
                System.out.println("                                         Welcome to Anuj's Library Management System.");
                System.out.println("************************************************************************************************************************");
                System.out.println("************************************************************************************************************************");
               
				conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAccountantDatabase(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url, userName, password);
                String Querry = "create database "+this.username;
				Statement pstm = conn.createStatement();
				//pstm.setString(1,this.username);
				
				pstm.execute(Querry);
                // System.out.println("Wait for few seconds to prepare your account to use.");
                // System.out.println("************************************************************************************************************************");
                // System.out.println("************************************************************************************************************************");
                System.out.println("                                         Wait for few seconds to prepare your account to use.");
                System.out.println("************************************************************************************************************************");
                System.out.println("************************************************************************************************************************");

				conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
    }

    //create student table

    public void createtable(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url+this.username, userName, password);
                String Querry = "create table studentlist (SRNO int primary key, SNAME varchar(255), SBRANCH varchar(200))";
				Statement pstm = conn.createStatement();
                pstm.execute(Querry);
				// System.out.println("                                         Now Sign in to your account.");
                System.out.println("************************************************************************************************************************");
                System.out.println("************************************************************************************************************************");
				// System.out.println("                                         Press any key to exit.");
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createBooklist(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url+this.username, userName, password);
                String Querry = "create table booklist (BSNO int primary key, BNAME varchar(255), BCATEGORIES varchar(200))";
				Statement pstm = conn.createStatement();
                pstm.execute(Querry);
				// System.out.println("                                         Now Sign in to your account.");
                // System.out.println("************************************************************************************************************************");
                // System.out.println("************************************************************************************************************************");
				System.out.println("                                         BSS KUCHH DER KI BAAT HAI:).");
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createcheckinlist(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url+this.username, userName, password);
                String Querry = "create table checkin (srno int, sbranch varchar(255), bname varchar(200), bid int primary key)";
				Statement pstm = conn.createStatement();
                pstm.execute(Querry);
				// System.out.println("                                         Now Sign in to your account.");
                // System.out.println("************************************************************************************************************************");
                // System.out.println("************************************************************************************************************************");
				// System.out.println("                                         Press any key to exit.");
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createcheckOUTlist(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url+this.username, userName, password);
                String Querry = "create table checkout (srno int, sbranch varchar(255), bname varchar(200), bid int primary key)";
				Statement pstm = conn.createStatement();
                pstm.execute(Querry);
				System.out.println("                                         Now Sign in to your account.");
                System.out.println("************************************************************************************************************************");
                System.out.println("************************************************************************************************************************");
				System.out.println("                                         Press any key to exit.");
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
