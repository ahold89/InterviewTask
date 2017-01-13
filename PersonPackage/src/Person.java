import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by asherh on 12/01/2017.
 */
public interface Person extends Comparable<Person>{

        public int getId();

        public String getFirstName();

        public String getLastName();

        public Date getDateOfBirth();

        public int getHeight();

}
