import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class PersonCollectionComparator {

    //By using this method, I don't implement Comparable<Person> in each implementing class of Person
    //therefore, in PersonCollection there can be only one kind of "compareTo" method
    public static int compare(Person p1, Person p2, Method comparingMethod) throws Exception{

        //Currently supplying only existing cases, but this makes PersonCollection
        // flexible for future changes, both in terms of according to new fields
        // and different comparison of existing fields
        switch (comparingMethod.getName()){
            case "getId":
            case "getHeight":
                try {
                    if ((int) comparingMethod.invoke(p1, null) < (int) comparingMethod.invoke(p2, null)){
                        return 1;
                    }else if ((int) comparingMethod.invoke(p1, null) > (int) comparingMethod.invoke(p2, null)){
                        return -1;
                    }else{
                        return 0;
                    }
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            case "getFirstName":
            case "getLastName":
                try {
                    return ((String) comparingMethod.invoke(p1, null))
                            .compareTo((String) comparingMethod.invoke(p2, null)) * -1;
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            case "getDateOfBirth":
                try {
                    if (((Date) comparingMethod.invoke(p1, null)).after((Date) comparingMethod.invoke(p2, null))){
                        return 1;
                    }else if (((Date) comparingMethod.invoke(p1, null)).before((Date) comparingMethod.invoke(p2, null))){
                        return -1;
                    }else{
                        return 0;
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
           default:
               throw new Exception("Could not compare items with id's: "
                                   + p1.getId() + " and " + p2.getId());
        }

    }
}
