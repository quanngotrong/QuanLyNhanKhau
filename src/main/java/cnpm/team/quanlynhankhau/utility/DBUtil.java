package cnpm.team.quanlynhankhau.utility;

import java.sql.*;

public class DBUtil {
    //username and password for database
    private static final String USERNAME = "root";
    private static final String PASSWORD = "passwordQuan@116";

    private static final String CONN_STRING = "jdbc:mysql://localhost/quanlynv";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }


    public static boolean authentification(String username, String password) throws SQLException{
        PreparedStatement stat = null;
        ResultSet res = null;
        Connection con= null;
        String sql = "SELECT * from account WHERE username= ? and password = ?";
        try{
            con = DBUtil.getConnection();
            stat = con.prepareStatement(sql);
            stat.setString(1,username);
            stat.setString(2, password);
            res = stat.executeQuery();
            if(res.next()){
                return res.getString("username").equals(username) && res.getString("password").equals(password);

            }else{
                return false;
            }
        } catch(Exception e){
            return false;
        }finally{
            res.close();
            stat.close();
            con.close();
        }
    }

}
