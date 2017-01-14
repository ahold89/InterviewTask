
public class SubscriberExtender extends Subscriber {

    public SubscriberExtender(PersonCollection personCollection) {
        super(personCollection);
    }

    @Override
    public void getNotification() {
        System.out.println("The new amount of people in collection is: "
                + mPersonCollection.GetNumberOfPeople());
    }
}
