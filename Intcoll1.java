import java.util.*;

public class Intcoll1 {

    public int[] c;

    /*
    Constructor without a parameter that finds storage capacity
    and ensures that c is empty.
     */
    public Intcoll1() {
        c = new int[500 + 1];
        c[0] = 0;
    }

    /*
    Constructor with an int parameter that finds storage capacity
    for int i and ensures that c is empty.
     */
    public Intcoll1(int i) {
        c = new int[i + 1];
        c[0] = 0;
    }

    /*
    Make collection 'this' have the same capacity as collection of
    object and contain the exact same elements as those of object.
     */
    public void copy(Intcoll1 obj) {
        if (this != obj) {
            c = new int[obj.c.length];
            int j = 0;
            while (obj.c[j] != 0) {
                c[j] = obj.c[j];
                j++;
            }
            c[j] = 0;
        }
    }

    /*
    Checks if value i is in the collection. Return true if it is.
     */
    public boolean belongs(int i) {
        int j = 0;
        while ((c[j] != 0) && (c[j] != i)) {
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
            while ((c[j] != 0) && (c[j] != i)) {
                j++;
            }
            if (c[j] == 0) {
                if (j == c.length - 1) {
                    int[] temp = new int[c.length * 2 - 1];
                    for (int k = 0; k < c.length; k++) {
                        temp[k] = c[k];
                    }
                    c = temp;
                }
                c[j] = i;
                c[j + 1] = 0;
            }
        }
    }

    /*
    Removes an int from the collection if it exists. Do nothing if not.
     */
    public void omit(int i) {
        if (i > 0) {
            int j = 0;
            while ((c[j] != 0) && (c[j] != i)) {
                j++;
            }
            if (c[j] == i) {
                int k = j + 1;
                while (c[k] != 0) {
                    k++;
                }
                c[j] = c[k - 1];
                c[k - 1] = 0;
            }
        }
    }

    /*
    Returns an int value of how many elements are in a collection.
     */
    public int get_howmany() {
        int j = 0, howmany = 0;

        while (c[j] != 0) {
            howmany++;
            j++;
        }
        return howmany;
    }

    /*
    Prints all the elements in a collection.
     */
    public void print() {
        int j = 0;
        System.out.println();
        while (c[j] != 0) {
            System.out.println(c[j]);
            j++;
        }
    }

    /*
    Checks whether the contents of one collection are the same as another
    collection. Return true if collections contain the same elements.
     */
    public boolean equals(Intcoll1 obj) {
        int j = 0;
        boolean result = true;
        while ((c[j] != 0) && result) {
            result = obj.belongs(c[j]);
            j++;
        }
        j = 0;
        while ((obj.c[j] != 0) && result) {
            result = belongs(obj.c[j]);
            j++;
        }
        return result;
    }
}
