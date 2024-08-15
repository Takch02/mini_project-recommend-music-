package Repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    private Connection conn = null;
    public Connection getConnection(){
        return conn;
    }

    public Connect() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/music";
        String user = "java";
        String password = "mysql";

        conn = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}