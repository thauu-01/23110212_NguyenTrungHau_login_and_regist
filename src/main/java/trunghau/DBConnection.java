package trunghau;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private final String serverName = "localhost";
    private final String dbName = "Online";
    private final String portNumber = "1433";
    private final String instance = ""; // Để trống cho instance mặc định

    // Kết nối với Windows Authentication, tắt mã hóa
    public Connection getConnectionW() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";integratedSecurity=true;databaseName=" + dbName + ";encrypt=false";
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";integratedSecurity=true;databaseName=" + dbName + ";encrypt=false";
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }

    // Test kết nối
    public static void main(String[] args) {
        try {
            System.out.println(new DBConnection().getConnectionW());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}