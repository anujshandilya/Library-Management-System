import java.sql.*;

public class delStudent {

public String username;
public String sname;
public String branch;
public int Regno;
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
    //delete student data
    public void del(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url+this.username, userName, password);
                String Querry = "DELETE FROM checkin WHERE sbranch = ? AND srno = ?";
                
				PreparedStatement pstm = conn.prepareStatement(Querry);
                pstm.setString(1,this.branch);
                // pstm.setString(2,this.branch);
                // pstm.setString(3,this.bookname);
                pstm.setInt(2, this.Regno);
                pstm.execute();
                System.out.println("Deleted!!");

                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
