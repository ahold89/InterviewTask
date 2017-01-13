import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;



public class PersonCollection {

    private ArrayList<Person> mPersonCollection = new ArrayList<>();
    private ArrayList<Subscriber> mSubscribers = new ArrayList<>();
    private Method mSortingMethod;

    public PersonCollection(Method sortingMethod){
        mSortingMethod = sortingMethod;
    }

    public synchronized void Add(Person person){

        //Check if array's size exceeds MAX_INT
        if (mPersonCollection.size() == Integer.MAX_VALUE){
            System.out.println("Cannot add more people");
            return;
        }

        boolean insertedPerson = false;
        for(int i = 0; i < mPersonCollection.size(); i++){

            //added twice the same person:
            if (mPersonCollection.get(i).getId() == person.getId()){
                System.out.println("There is already someone with this ID: " + person.getId());
                return;
            }

            try {
                //person is bigger than mPersonCollection.get(i)
                if (person.compareTo(mPersonCollection.get(i)) == 1){
                    mPersonCollection.add(i, person);
                    insertedPerson = true;
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        //Reached the end of the arraylist
        if (!insertedPerson){
            mPersonCollection.add(person);
        }

        //notify subscribers
        Publish();
    }

    public synchronized Person Remove(){

        //Since the arraylist is sorted, removing the last element is done in O(1)
        Person removedPerson = mPersonCollection.remove(mPersonCollection.size() - 1);

        //notify subscribers:
        Publish();
        return removedPerson;
    }


    public void Publish() {
        notifyAllObservers();
    }

    public int GetNumberOfPeople() {
        return mPersonCollection.size();
    }

    public Person GetPerson(int index){
      return mPersonCollection.get(index);
    }

    public Method GetSortingMethod(){
        return mSortingMethod;
    }

    public synchronized void attach(Subscriber subscriber){
        mSubscribers.add(subscriber);
    }

    private void notifyAllObservers(){
        for (Subscriber subscriber : mSubscribers) {
            subscriber.getNotification();
        }
    }

}
