package chucnangdangnhap;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=hau;encrypt=false";    
        String user = "hau";
        String pass = "123";
        return DriverManager.getConnection(url, user, pass);
    }
}