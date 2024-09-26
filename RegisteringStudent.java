import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RegisteringStudent {
    public String username;
    public int sid;
    public String sname;
    public String sbranch;
    public void Registeringstudent(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
				String userName = "root";
				String password = "Anuj2003@";
				
				Connection conn = DriverManager.getConnection(url+this.username, userName, password);
                String Querry = "INSERT INTO studentlist values (?,?,?)";
                
				PreparedStatement pstm = conn.prepareStatement(Querry);
                pstm.setInt(1,this.sid);
                pstm.setString(2,this.sname);
                pstm.setString(3,this.sbranch);
                pstm.execute();
                System.out.println("Registered");

                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
