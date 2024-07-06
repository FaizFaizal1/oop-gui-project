import java.sql.*;
import java.util.ArrayList;

class DBHelper {
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> custList = new ArrayList<Customer>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/csc435groupproject", "root", "123");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next()) {
                Customer cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4));
                custList.add(cust);
            }
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return custList;
    }

}