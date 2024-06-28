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

//    public ArrayList<Integer> getAllTrackingNumber() {
//        ArrayList<Integer> trackingNumberList = new ArrayList<Integer>();
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/csc435groupproject", "root", "123");
//
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from customer");
//            while (rs.next()) {
//                trackingNumberList.add(rs.getInt(3));
//            }
//            con.close();
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return trackingNumberList;
//    }

    public static void main(String[] args) {
        DBHelper db = new DBHelper();
        ArrayList<String> test = db.getAllCustomerNames();
        for (String name : test) {
            System.out.println(name);
        }
    }
}