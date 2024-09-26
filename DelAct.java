import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DelAct {
    public int mob;
    public String username;
    public String email;

    // Verification
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
             pstm.setString(1, this.username);  
             pstm.setInt(2, this.mob);  
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

    // delete database
    public void deldatabase(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url, userName, password);
                 
                String databaseName = this.username; 
                String query = "DROP DATABASE " + databaseName;  
            
                // Prepare the statement  
                PreparedStatement pstm = conn.prepareStatement(query);  
                
                // Execute the statement  
                pstm.execute();  
                System.out.println("Data Deleted!!");

                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deldata(){
        try {
            String url = "jdbc:mysql://localhost:3306/lms";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url, userName, password);
                String Querry = "DELETE FROM accounts WHERE username = ? AND mob = ?";
                
				PreparedStatement pstm = conn.prepareStatement(Querry);
                pstm.setString(1,this.username);
                // pstm.setString(2,this.branch);
                // pstm.setString(3,this.bookname);
                pstm.setInt(2, this.mob);
                pstm.execute();
                System.out.println("Account Removed!!");

                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
