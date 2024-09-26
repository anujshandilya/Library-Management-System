
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListOFbooks {

    public String username;


    public void ListOfbooks(){
        ResultSet rs = null;
        try {
            
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "Anuj2003@";

            Connection conn = DriverManager.getConnection(url+this.username, userName, password);
            String Querry = "(SELECT * FROM booklist)";

            Statement stm = conn.createStatement();

            rs = stm.executeQuery(Querry); // Execute the query  

            // Process the result set  
            while (rs.next()) {  
                // Assuming columns in booklist are id (int) and title (String)  
                int BSNO = rs.getInt("BSNO"); // Adjust according to your table structure  
                String BNAME = rs.getString("BNAME");
                String BCATEGORIES = rs.getString("BCATEGORIES");

                System.out.println("SERIAL NUMBER: " + BSNO + ", NAME: " + BNAME + " CATEGORY:" + BCATEGORIES);  
            }  


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
