package config;
import objects.Person;
import org.junit.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateMent {
    public static Statement getStateMent() {
        return stateMent;
    }
    private static Statement stateMent;
    public StateMent() {
        try {
            makeStat();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Statement makeStat() throws SQLException {
        Connect c =null;
        c=new Connect();
        Connection con=c.newConnection();
        stateMent=con.createStatement();
        return stateMent;
    }
    public static Person getPersonForId(int id) throws SQLException {
        ResultSet resultSet = getStateMent().executeQuery("SELECT * FROM sys.hillel_my where id='" + id + "';");
        resultSet.next();
        return new Person(resultSet);
    }
    public List<Map<String,String>> getUsersList() throws SQLException {
        ResultSet resultSet=stateMent.executeQuery("select * from sys.hillel_my where address = 'Kharkiv'");
        List<Map<String,String>> list=new ArrayList<>();
        while(resultSet.next()){
            Map<String,String> map=new HashMap<>();
            map.put("id",resultSet.getString("id"));
            map.put("name",resultSet.getString("name"));
            map.put("address",resultSet.getString("address"));
            list.add(map);
        }
        return list;
    }
    public void selectAll() throws SQLException {
        ResultSet resultSet= stateMent.executeQuery("SELECT * FROM sys.hillel_my;");
        while(resultSet.next()){
            System.out.println(resultSet.getString("id")+" "+resultSet.getString("name")+" "+resultSet.getString("address"));
        }
    }

    public List<Map<String,String>> getRows() throws SQLException {
        ResultSet resultSet=stateMent.executeQuery("SELECT * FROM sys.hillel_my;");
        List<Map<String,String>> list=new ArrayList<>();
        while(resultSet.next()){
            Map<String,String> map=new HashMap<>();
            map.put("id",resultSet.getString("id"));
            map.put("name",resultSet.getString("name"));
            map.put("address",resultSet.getString("address"));
            list.add(map);
        }
        return list;
    }
}
