
import java.util.Date;


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
    public synchronized int getId() {
        return mId;
    }

    @Override
    public synchronized String getFirstName() {
        return mFirstName;
    }

    @Override
    public synchronized String getLastName() {
        return mLastName;
    }

    @Override
    public synchronized Date getDateOfBirth() {
        return mDateOfBirth;
    }

    @Override
    public synchronized int getHeight() {
        return mHeight;
    }

    //Setters...

}
