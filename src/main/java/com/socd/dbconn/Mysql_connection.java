package com.socd.dbconn;
import java.sql.*;
public class Mysql_connection {
	Connection conn;

    public Mysql_connection() throws Exception {
            try {

                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    String url = "jdbc:mysql://localhost/cdcatalog";

                    conn = DriverManager.getConnection(url,"root","");

            } catch (SQLException e) {

                    // Handle error

                    e.printStackTrace();

            }

    }

    public ResultSet queryTable(String query) throws Exception {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;

    }

    public void executeTable(String query) throws Exception {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
    }
    

    public void endConnection() throws Exception {
            conn.close();
            conn = null;
    }
}
