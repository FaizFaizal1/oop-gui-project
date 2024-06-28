import java.sql.*;
import java.util.ArrayList;

class DBHelper {
    public ArrayList<String> getAllCustomerNames() {
        ArrayList<String> custList = new ArrayList<String>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/csc435groupproject", "root", "123");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next()) {
                custList.add(rs.getString(2));
            }
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return custList;
    }
}