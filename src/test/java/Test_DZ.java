import config.StateMent;
import objects.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Map;

import static config.StateMent.getPersonForId;

public class Test_DZ {
    static StateMent stateMent;

    @BeforeClass
    public static void bb() {
        stateMent = new StateMent();
    }
    @Test
    public void testUsernameById() throws SQLException {
        Person person = getPersonForId(7);
        System.out.println(person.name);
    }

    @Test
    public void testSameAddress() throws SQLException {
        for (Map<String, String> row : stateMent.getUsersList()) {
            System.out.println(row);
        }
    }
}
