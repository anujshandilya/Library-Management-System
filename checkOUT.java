import java.sql.*;

public class checkOUT {

    public String username;
    public int Regno;
    public String branch;
    public String bookname;
    public int bookid;

    // Verification of the registered Student
    public boolean verification(){
        ResultSet rs = null;
        try {
            
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "Anuj2003@";

            Connection conn = DriverManager.getConnection(url+this.username, userName, password);
            
            String Querry = "(SELECT sbranch AND srno FROM studentlist WHERE sbranch =? AND srno = ?);";


            PreparedStatement pstm = conn.prepareStatement(Querry);

             // Prepare statement  
             pstm = conn.prepareStatement(Querry);  
             pstm.setString(1, branch);  
             pstm.setInt(2, Regno);  
             rs = pstm.executeQuery();
 
             // Execute query  
             ResultSet resultSet = pstm.executeQuery();  
             boolean verifiction = resultSet.next(); 
             conn.close();
             if(verifiction==true) {  
                return true;  
            } else {
                return false;
            } 
 
            } catch (Exception e) {
            // e.printStackTrace();
         return false;
        } 
    }

    // enter details to the studentlisttable

    public void checkout(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url+this.username, userName, password);
                String Querry = "INSERT INTO checkout values (?,?,?,?)";
                
				PreparedStatement pstm = conn.prepareStatement(Querry);
                pstm.setInt(1,this.Regno);
                pstm.setString(2,this.branch);
                pstm.setString(3,this.bookname);
                pstm.setInt(4, bookid);
                pstm.execute();
                System.out.println("Checked out!!");

                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Remove from check in
    public void checkinremoval(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url+this.username, userName, password);
                String Querry = "DELETE FROM checkin WHERE bid=? AND srno = ?";
                
				PreparedStatement pstm = conn.prepareStatement(Querry);
                pstm.setInt(1,this.Regno);
                // pstm.setString(2,this.branch);
                // pstm.setString(3,this.bookname);
                pstm.setInt(2, bookid);
                pstm.execute();
                System.out.println("Checked out!!");

                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}


