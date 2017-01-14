
public class PersonCollectionComparator {

    //By using this method, I don't implement Comparable<Person> in each implementing class of Person
    //therefore, in PersonCollection there can be only one kind of "compareTo" method
    public static int compare(Person p1, Person p2) {
        //This changes according to implementation, once all Person methods are set,
        //it'll be posible to compare according to method using reflection e.g:
        //(int) sortingCriteriaAlgorithm.invoke(p1, null) < (int) sortingCriteriaAlgorithm.invoke(p2, null)

        if (p1.getId() < p2.getId()){
            return 1;
        }else if (p1.getId() > p2.getId()){
            return -1;
        }else{
            return 0;
        }
    }
}
