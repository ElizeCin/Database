package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class Connect {

    private Connection collection;
    public Connection newConnection() throws SQLException {
        if(collection==null){
            collection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","root");
        }
        return collection;
    }

    public Connect() throws SQLException {
        newConnection();
    }
}