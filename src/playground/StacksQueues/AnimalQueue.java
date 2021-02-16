package playground.StacksQueues;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalQueue {

    Queue<Dog> dogs;
    Queue<Cat> cats;
    int order;

    public AnimalQueue() {
        dogs = new LinkedList<Dog>();
        cats = new LinkedList<Cat>();
        this.order = 0;
    }

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;

        if (a instanceof Dog) {
            dogs.offer((Dog) a);
        } else if (a instanceof Cat) {
            cats.offer((Cat) a);
        }
    }

    public Animal dequeueAny() {
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

}
