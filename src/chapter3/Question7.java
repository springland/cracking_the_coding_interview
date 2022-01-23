package chapter3;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * An animal shelter holds only dogs and cats, and operate on a strickly "first in , first out" basis.
 * People must adopt either the "oldest" or they can select whether they would prefer a dog or a cat.
 * They cannot select which specific animal they would like. Create the data structure
 * to main this system and implement operations such as enqueue , dequeueAny , dequeueDog
 * dequeueCat. You may use the built-in LinkedList data structure
 */
public class Question7 {

    class Animal{
        int id ;
        Animal(int id)
        {
            this.id = id ;
        }


    }
    class Dog extends Animal {
        Dog(int id)
        {
            super(id);
        }
    }

    class Cat extends Animal {
        Cat(int id)
        {
            super(id);
        }
    }

    class Slot {
        Animal  animal ;
        int index ;

        public Slot(Animal animal , int index)
        {
            this.animal = animal ;
            this.index = index ;
        }
    }
    LinkedList<Slot> dogs = new LinkedList<>();
    LinkedList<Slot> cats = new LinkedList<>();
    public void enqueue(Animal animal)
    {
        int lastIndex = 0;
        if(!cats.isEmpty())
        {
            lastIndex = cats.getLast().index+1 ;
        }
        if(!dogs.isEmpty())
        {
            if(dogs.getLast().index >= lastIndex)
            {
                lastIndex = dogs.getLast().index +1 ;
            }
        }

        Slot slot = new Slot(animal , lastIndex);
        if(animal instanceof Cat)
        {
            cats.add(slot);
        }
        if(animal instanceof Dog)
        {
            dogs.add(slot);
        }

    }

    public Animal dequeueAny()
    {
        if(!cats.isEmpty() && !dogs.isEmpty())
        {
            if(cats.getFirst().index < dogs.getFirst().index)
            {
                return cats.removeFirst().animal;
            }
            else
            {
                return dogs.removeFirst().animal;
            }
        }

        if(!cats.isEmpty())
        {
            return cats.removeFirst().animal;
        }

        if(!dogs.isEmpty())
        {
            return dogs.removeFirst().animal;
        }

        return null;
    }

    public Dog dequeueDog()
    {
        return (Dog)dogs.removeFirst().animal;
    }

    public Cat dequeueCat()
    {
        return  (Cat)cats.removeFirst().animal;
    }

    @Test
    public void test()
    {
        Dog d1 = new Dog(1);
        Dog d2 = new Dog(3);
        Dog d3 = new Dog(5);

        Cat c1 = new Cat(2);
        Cat c2 = new Cat(4);

        enqueue(d1);
        enqueue(d2);
        enqueue(c1);
        enqueue(c2);
        enqueue(d3);

        assertEquals(dequeueCat() , c1);
        assertEquals(dequeueAny() , d1);
        assertEquals(dequeueAny() , d2);
        assertEquals(dequeueDog() , d3);
        assertEquals(dequeueAny() , c2);

        assertNull(dequeueAny());
    }
}
