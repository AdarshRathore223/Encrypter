import java.sql.*;
public class jdbc {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-PCVGGS4F:1521:xe", "encrypter", "encrypter"); 
//            String q = "select unique_id from key_table";
            String q = " SELECT table_name FROM user_tables";
            
            Statement stmt =con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while (set.next()) {
            String temp =set.getString(1);
            System.out.println(temp);
            }
//            String q = "insert into example values('Input from jdbc')";
//            PreparedStatement stmt = con.prepareStatement(q);
//            stmt.executeUpdate();
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
