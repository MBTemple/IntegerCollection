/*
Maamar Bousseloub
CIS 2168.009
Intcoll2
 */

import java.util.*;

public class Intcoll2 {

    private int[] c;
    private int howmany;

    /*
    Constructor without a parameter that finds storage capacity
    and ensures that c is empty.
     */
    public Intcoll2() {
        c = new int[500];
        howmany = 0;
    }

    /*
    Constructor with an int parameter that finds storage capacity
    for int i and ensures that c is empty.
     */
    public Intcoll2(int i) {
        c = new int[i];
        howmany = 0;
    }

    /*
    Make collection 'this' have the same capacity as collection of
    object and contain the exact same elements as those of object.
     */
    public void copy(Intcoll2 obj) {
        if (this != obj) {
            c = new int[obj.c.length];
            int j = 0;
            while (j < obj.c.length) {
                c[j] = obj.c[j];
                j++;
            }
            howmany = obj.howmany;
        }
    }

    /*
    Checks if value i is in the collection. Return true if it is.
     */
    public boolean belongs(int i) {
        int j = 0;
        while ((j < howmany) && (c[j] != i)) {
            j++;
        }
        return ((i > 0) && (c[j] == i));
    }

    /*
    Inserts an int into the collection. Do nothing if int already exists.
     */
    public void insert(int i) {
        if (i > 0) {
            int j = 0;
            while ((j < howmany) && (c[j] != i)) {
                j++;
            }
            if (j == howmany) {
                if (j == c.length) {
                    int[] temp = new int[c.length * 2];
                    for (int k = 0; k < c.length; k++) {
                        temp[k] = c[k];
                    }
                    c = temp;
                }
                c[j] = i;
                howmany++;
            }
        }
    }

    /*
    Removes an int from the collection if it exists. Do nothing if not.
     */
    public void omit(int i) {
        if (i > 0) {
            int j = 0;
            while ((j < howmany) && (c[j] != i)) {
                j++;
            }
            if (c[j] == i) {
                howmany--;
                c[j] = c[howmany];
            }
        }
    }

    /*
    Returns an int value of how many elements are in a collection.
     */
    public int get_howmany() {
        return howmany;
    }

    /*
    Prints all the elements in a collection.
     */
    public void print() {
        int j = 0;
        System.out.println();
        while (j < howmany) {
            System.out.println(c[j]);
            j++;
        }
    }

    /*
    Checks whether the contents of one collection are the same as another
    collection. Return true if collections contain the same elements.
     */
    public boolean equals(Intcoll2 obj) {
        int j = 0;
        boolean result = (howmany == obj.howmany);
        while ((j < howmany) && result) {
            result = belongs(obj.c[j]);
            j++;
        }
        return result;
    }
}
