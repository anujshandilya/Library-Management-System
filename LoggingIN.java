import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoggingIN {

    public String username;
    public int mob;


    public boolean verification(){
        ResultSet rs = null;
        try {
            
            String url = "jdbc:mysql://localhost:3306/lms";
            String userName = "root";
            String password = "Anuj2003@";

            Connection conn = DriverManager.getConnection(url, userName, password);
            
            String Querry = "(SELECT username AND mob FROM accounts WHERE username =? AND mob = ?);";


            PreparedStatement pstm = conn.prepareStatement(Querry);

             // Prepare statement  
             pstm = conn.prepareStatement(Querry);  
             pstm.setString(1, username);  
             pstm.setInt(2, mob);  
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





}
