import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class recover_account {
    public String company;
    public String name;
    public String email;

    // Verification
    public boolean verification(){
        ResultSet rs = null;
        try {
            
            String url = "jdbc:mysql://localhost:3306/lms";
            String userName = "root";
            String password = "Anuj2003@";

            Connection conn = DriverManager.getConnection(url, userName, password);
            
            String Querry = "(SELECT name AND company FROM accounts WHERE name =? AND company = ?);";


            PreparedStatement pstm = conn.prepareStatement(Querry);

             // Prepare statement  
             pstm = conn.prepareStatement(Querry);  
             pstm.setString(1, this.name);  
             pstm.setString(2, this.company);  
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

    // Show all data

    public void showlist(){
        ResultSet rs = null;
        try {
            
            String url = "jdbc:mysql://localhost:3306/lms";
            String userName = "root";
            String password = "Anuj2003@";

            Connection conn = DriverManager.getConnection(url, userName, password);
            String Querry = "SELECT * FROM accounts where name = ? and company = ?";

            

            PreparedStatement stm = conn.prepareStatement(Querry);
            stm.setString(1, this.name);
            stm.setString(2, this.company);

            rs = stm.executeQuery(); // Execute the query  

            // Process the result set  
            while (rs.next()) {  
                 
                String NAME = rs.getString("NAME");  
                String USERNAME = rs.getString("USERNAME");
                String COMPANY = rs.getString("COMPANY");
                int MOB = rs.getInt("MOB");
                String EMAIL = rs.getString("EMAIL");
                System.out.println("NAME: " + NAME + " USERNAME: " + USERNAME + " COMPANY: " + COMPANY +" MOB NO: "+MOB+" EMAIL: "+EMAIL);  
            }  


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
