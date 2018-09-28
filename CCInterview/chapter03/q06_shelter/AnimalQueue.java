import java.util.LinkedList;

public class AnimalQueue {

    private int last_order;

    private LinkedList<Cat> cats;
    private LinkedList<Dog> dogs;

    public AnimalQueue() {
       cats = new LinkedList<Cat>();
       dogs = new LinkedList<Dog>();
       last_order = 0;
    }


    public void enqueue(Animal a) {
        a.setOrder(last_order);
        last_order++;
        if (a instanceof Cat) {
            cats.addLast((Cat) a);
        } else if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        }
    }


    public Animal dequeueAny() {
        if (cats.isEmpty()) {
            return dequeueDog();
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        }

        if (cats.peekFirst().olderThan(dogs.peekFirst())) {
            return cats.removeFirst();
        } 
        return dogs.removeFirst();
    }


    public Animal dequeueCat() {
        return cats.removeFirst();   
    }


    public Animal dequeueDog() {
        return dogs.removeFirst();   
    }


    public int size() {
        return cats.size() + dogs.size(); 
    }


    public void print() {
        System.out.print ("\n===");
        for (Animal a : cats) {
            System.out.print (a.name() + ",  ");
        }
        System.out.print ("\n===");
        for (Animal d : dogs) {
            System.out.print (d.name() + ",  ");
        }
        System.out.println();
    }

}