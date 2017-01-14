import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonCollectionComparator {

    //By using this method, I don't implement Comparable<Person> in each implementing class of Person
    //therefore, in PersonCollection there can be only one kind of "compareTo" method
    public static int compare(Person p1, Person p2, Method comparingMethod) {

        //Currently supplying only one case, but it is flexible for future changes
        switch (comparingMethod.getName()){
            case "getId":
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

            default:
                return 0;
        }

    }
}
