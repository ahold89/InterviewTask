import java.util.Date;

/**
 * Created by asherh on 13/01/2017.
 */
public class Main {

    public static void main(String[] args){
        Programmer p1 = new Programmer(1,"asher", "holder", new Date(System.currentTimeMillis()), 189);
        Programmer p2 = new Programmer(0,"dudu", "tasa", new Date(System.currentTimeMillis()), 182);
        Programmer p3 = new Programmer(2,"simon", "says", new Date(System.currentTimeMillis()), 180);
        Programmer p4 = new Programmer(3,"dora", "explorer", new Date(System.currentTimeMillis()), 110);

        try {
            Class personClass = Class.forName("Person");
            PersonCollection personCollection = new PersonCollection(personClass.getDeclaredMethod("getHeight"));
            SubscriberExtender subscriberExtender = new SubscriberExtender(personCollection);
            personCollection.attach(subscriberExtender);
            personCollection.Add(p1);
            personCollection.Add(p2);
            personCollection.Add(p3);
            personCollection.Add(p4);
            Person p = personCollection.Remove();
            System.out.println(p.getFirstName());
            for (int i = 0; i < personCollection.GetNumberOfPeople(); i++){
                System.out.println(personCollection.GetPerson(i).getFirstName());
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }


    }
}
