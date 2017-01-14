import java.util.ArrayList;


public class PersonCollection extends PersonCollectionComparator {

    private ArrayList<Person> mPersonCollection = new ArrayList<>();
    private ArrayList<Subscriber> mSubscribers = new ArrayList<>();


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

            //Currently the try catch mechanism is not needed, but if we work with reflections in the future, it will.
            try {
                //person is bigger than mPersonCollection.get(i) regardless of how it was implemented
                if (compare(person, mPersonCollection.get(i)) == 1){
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


    public synchronized void Publish() {
        notifyAllObservers();
    }

    public synchronized int GetNumberOfPeople() {
        return mPersonCollection.size();
    }

    public synchronized Person GetPerson(int index){
      return mPersonCollection.get(index);
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
