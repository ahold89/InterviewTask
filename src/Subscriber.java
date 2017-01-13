
public abstract class Subscriber {

    protected PersonCollection mPersonCollection;

    public Subscriber(PersonCollection personCollection){
        mPersonCollection = personCollection;
    }

    public abstract void getNotification();
}
