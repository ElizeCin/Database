package objects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Person {
    public int id;

    public Person(ResultSet resultSet) throws SQLException {
        this.id = Integer.parseInt(resultSet.getString("id"));
        this.name = resultSet.getString("name");
        this.address = resultSet.getString("address");
        this.description = resultSet.getString("description");
        this.date = resultSet.getString("date");
    }

    public Person(int id, String name, String address, String description, String date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.date = date;
    }

    public String name,address,description,date;
}