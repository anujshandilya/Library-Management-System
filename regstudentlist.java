
import java.sql.*;

public class regstudentlist {
    public String username;

    public void Registeredslist(){
         ResultSet rs = null;
        try {
            
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "Anuj2003@";

            Connection conn = DriverManager.getConnection(url+this.username, userName, password);
            String Querry = "SELECT * FROM studentlist";

            Statement stm = conn.createStatement();

            rs = stm.executeQuery(Querry); // Execute the query  

            // Process the result set  
            while (rs.next()) {  
                // Assuming columns in booklist are id (int) and title (String)  
                int BSNO = rs.getInt("SRNO"); // Adjust according to your table structure  
                String BNAME = rs.getString("SNAME");
                String BCATEGORIES = rs.getString("SBRANCH");

                System.out.println("REGISTRATION NUMBER: " + BSNO + ", NAME: " + BNAME + " BRANCH:" + BCATEGORIES);  
            }  


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
