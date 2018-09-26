package intcoll5;

import java.util.*;

public class Intcoll5 {

    private LinkedList<Integer> c;

    /*
    Constructor without a parameter that finds storage capacity
    and ensures that c is empty.
     */
    public Intcoll5() {
        c = new LinkedList<Integer>();
    }

    /*
    Constructor with an int parameter that finds storage capacity
    for int i and ensures that c is empty.
     */
    public Intcoll5(int i) {
        c = new LinkedList<Integer>();
    }

    /*
    Make collection 'this' have the same capacity as collection of
    object and contain the exact same elements as those of object.
     */
    public void copy(Intcoll5 obj) {
        LinkedList<Integer> temp = new LinkedList<>();
        ListIterator<Integer> I = obj.c.listIterator();
        while (I.hasNext()) {
            temp.add(I.next());
        }
        c = temp;
    }

    /*
    Checks if value i is in the collection. Return true if it is.
     */
    public boolean belongs(int i) {
        return c.contains(i);
    }

    /*
    Inserts an int into the collection. Do nothing if int already exists.
     */
    public void insert(int i) {
        Integer I = new Integer(i);
        if ((i > 0) && (!c.contains(i))) {
            c.addFirst(I);
        }
    }

    /*
    Removes an int from the collection if it exists. Do nothing if not.
     */
    public void omit(int i) {
        if ((i > 0) && (c.contains(i))) {
            c.remove(new Integer(i));
        }
    }

    /*
    Returns an int value of how many elements are in a collection.
     */
    public int get_howmany() {
        return c.size();
    }

    /*
    Prints all the elements in a collection.
     */
    public void print() {
        ListIterator<Integer> I = c.listIterator();
        while (I.hasNext()) {
            System.out.println(I.next());
        }
    }

    /*
    Checks whether the contents of one collection are the same as another
    collection. Return true if collections contain the same elements.
     */
    public boolean equals(Intcoll5 obj) {
        boolean result = true;
        if (c.size() != obj.c.size()) {
            return false;
        }
        ListIterator<Integer> I = obj.c.listIterator();
        while (I.hasNext() && result) {
            result = belongs(I.next());
        }
        return result;
    }
}
