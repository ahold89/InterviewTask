/**
 * Created by asherh on 13/01/2017.
 */
public abstract class Subscriber {

    protected PersonCollection mPersonCollection;

    public Subscriber(PersonCollection personCollection){
        mPersonCollection = personCollection;
    }

    public abstract void getNotification();
}
