import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by asherh on 14/01/2017.
 */
public class Main {

    public static void main(String[] args){
        Person p1 = new Programmer(0, "asher", "holder", new Date(System.currentTimeMillis()), 188);
        Person p2 = new Programmer(1, "ross", "geller", new Date(System.currentTimeMillis()), 183);
        Person p3 = new Programmer(2, "chandler", "bing", new Date(System.currentTimeMillis()), 182);
        Person p4 = new Programmer(3, "dora", "explorer", new Date(System.currentTimeMillis()), 110);


        try {
            Method comparingMethod = Class.forName("Person").getMethod("getId");
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
