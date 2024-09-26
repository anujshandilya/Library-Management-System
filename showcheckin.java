import java.io.PrintStream;
import java.sql.*;
public class showcheckin {
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

    // show list

    public void showlist(){
        ResultSet rs = null;
        try {
            
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "Anuj2003@";

            Connection conn = DriverManager.getConnection(url+this.username, userName, password);
            String Querry = "SELECT * FROM checkin where srno = ? and sbranch = ?";

            

            PreparedStatement stm = conn.prepareStatement(Querry);
            stm.setInt(1, Regno);
            stm.setString(2, branch);

            rs = stm.executeQuery(); // Execute the query  

            // Process the result set  
            while (rs.next()) {  
                // Assuming columns in booklist are id (int) and title (String)  
                int BSNO = rs.getInt("SRNO"); // Adjust according to your table structure  
                String BNAME = rs.getString("SBRANCH");
                String BCATEGORIES = rs.getString("BNAME");
                int bid = rs.getInt("bid");

                System.out.println("REGISTRATION NUMBER: " + BSNO + " BRANCH: " + BCATEGORIES + " Book Name: " + BCATEGORIES +" Book ID: "+bid);  
            }  


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
