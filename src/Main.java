import java.lang.reflect.Method;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        Person p1 = new Programmer(0, "asher", "holder", new Date(1), 188);
        Person p2 = new Programmer(1, "ross", "geller", new Date(2), 183);
        Person p3 = new Programmer(2, "chandler", "bing", new Date(3), 182);
        Person p4 = new Programmer(3, "dora", "explorer", new Date(4), 110);


        try {
            Method comparingMethod = Class.forName("Person").getMethod("getDateOfBirth");
            PersonCollection personCollection = new PersonCollection(comparingMethod);
            Subscriber subscriberExtender = new SubscriberExtender(personCollection);
            personCollection.attach(subscriberExtender);
            personCollection.Add(p3);
            personCollection.Add(p1);
            personCollection.Add(p2);
            personCollection.Add(p4);
            for (int i = 0; i < personCollection.GetNumberOfPeople(); i++){
                System.out.println(personCollection.GetPerson(i).getFirstName());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
