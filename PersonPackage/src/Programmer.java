import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by asherh on 13/01/2017.
 */
public class Programmer implements Person{

    private int mId;
    private int mHeight;
    private String mFirstName;
    private String mLastName;
    private Date mDateOfBirth;

    public Programmer(int id, String name, String lastName, Date dateOfBirth, int heigth){
        mId = id;
        mFirstName = name;
        mLastName = lastName;
        mDateOfBirth = dateOfBirth;
        mHeight = heigth;
    }

    @Override
    public int getId() {
        return mId;
    }

    @Override
    public String getFirstName() {
        return mFirstName;
    }

    @Override
    public String getLastName() {
        return mLastName;
    }

    @Override
    public Date getDateOfBirth() {
        return mDateOfBirth;
    }

    @Override
    public int getHeight() {
        return mHeight;
    }

    @Override
    public int compareTo(Person o) {
        //This changes according to implementation, but since "Programmer" is my implementation:
        if (this.getId() < o.getId()){
            return 1;
        }else if (this.getId() > o.getId()){
            return -1;
        }else{
            return 0;
        }
    }
}
