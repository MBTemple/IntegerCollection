import java.util.*;

public class Intcoll3 {

    private boolean[] c;
    private int howmany;

    /*
    Constructor without a parameter that finds storage capacity
    and ensures that c is empty.
     */
    public Intcoll3() {
        c = new boolean[500];
        howmany = 0;
    }

    /*
    Constructor with an int parameter that finds storage capacity
    for int i and ensures that c is empty.
     */
    public Intcoll3(int i) {
        c = new boolean[i];
        for (int j = 0; j < c.length; j++) {
            c[j] = false;
        }
        howmany = 0;
    }

    /*
    Make collection 'this' have the same capacity as collection of
    object and contain the exact same elements as those of object.
     */
    public void copy(Intcoll3 obj) {
        if (this != obj) {
            c = new boolean[obj.c.length];
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
        if ((i > 0) && (i < c.length)) {
            return c[i];
        }
        return false;
    }

    /*
    Inserts an int into the collection. Do nothing if int already exists.
     */
    public void insert(int i) {
        if ((i > 0) && (i >= c.length)) {
            boolean[] temp = new boolean[i * 2];

            for (int j = 0; j < c.length; j++) {
                if (j < c.length) {
                    temp[j] = c[j];
                } else {
                    temp[j] = false;
                }
            }
            c = temp;
        }
        c[i] = true;
        howmany++;
    }


    /*
    Removes an int from the collection if it exists. Do nothing if not.
     */
    public void omit(int i) {
        if ((i > 0) && (i < c.length)) {
            c[i] = false;
            howmany--;
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
        System.out.println();
        for (int i = 0; i < c.length; i++) {
            if (c[i]) {
                System.out.println(i);
            }
        }
    }

    /*
    Checks whether the contents of one collection are the same as another
    collection. Return true if collections contain the same elements.
     */
    public boolean equals(Intcoll3 obj) {

        boolean result = true;
        int i = 0;
        while ((i < c.length) && result) {
            if (c[i] == obj.c[i]) {
                result = true;
            } else if (obj.howmany != howmany) {
                return false;
            } else {
                result = false;
            }
            i++;
        }
        return true;
    }
}
