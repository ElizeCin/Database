package work;
import config.StateMent;
import objects.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQuery extends StateMent {
    public static List<Person> selectObj() throws SQLException {
        ResultSet resultSet = getStateMent().executeQuery("SELECT * FROM sys.hillel_my;");
        List<Person> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Person(resultSet));
        }
        return list;
    }

    public static Person getPersonForName(String name) throws SQLException {
        ResultSet resultSet = getStateMent().executeQuery("SELECT * FROM sys.hillel_my where name='" + name + "';");
        resultSet.next();
        return new Person(resultSet);
    }

}