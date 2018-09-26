import java.util.*;

public class Intcoll4 {

    private ListItem c;
    private int howmany;

    /*
    Constructor without a parameter that finds storage capacity
    and ensures that c is empty.
     */
    public Intcoll4() {
        c = null;
        howmany = 0;
    }

    /*
    Constructor with an int parameter that finds storage capacity
    for int i and ensures that c is empty.
     */
    public Intcoll4(int i) {
        c = null;
        howmany = 0;
    }

    /*
    Make collection 'this' have the same capacity as collection of
    object and contain the exact same elements as those of object.
     */
    public void copy(Intcoll4 obj) {
        ListItem q;
        ListItem p;

        if (this != obj) {
            this.howmany = obj.howmany;
        }
        if (obj.c == null) {
            c = null;
        } else {
            p = obj.c;
            c = new ListItem(p.info, null);
            q = c;
            p = p.link;

            while (p != null) {
                q.link = new ListItem(p.info, null);
                //so q and p know where to point to next
                q = q.link;
                p = p.link;
            }

        }
    }

    /*
    Checks if value i is in the collection. Return true if it is.
     */
    public boolean belongs(int i) {
        ListItem p = c;
        while ((p != null) && (p.info != i)) {
            p = p.link;
        }
        return (p != null);
    }

    /*
    Inserts an int into the collection. Do nothing if int already exists.
     */
    public void insert(int i) {
        if (i > 0) {
            ListItem p = c;
            while ((p != null) && (p.info != i)) {
                p = p.link;
            }
            if (p == null) /*{
              p = new ListItem();
              p.link = c;
              c = p;
              p.info = i;
              howmany++;
            }*/ {
                p = new ListItem(i, c);
                c = p;
                howmany++;
            }
        }
    }

    /*
    Removes an int from the collection if it exists. Do nothing if not.
     */
    public void omit(int i) {
        if (i > 0) {
            ListItem p = c;
            ListItem pred = null;
            while ((p != null) && (p.info != i)) {
                pred = p;
                p = p.link;
            }
            if (p != null) {
                if (pred != null) {
                    pred.link = p.link;
                } else {
                    //condition for ommiting first object
                    //set c to the next item in the list
                    c = p.link;
                }
                howmany--;
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
        ListItem p = c;
        System.out.println();
        while (p != null) {
            System.out.println(p.info);
            p = p.link;
        }
    }

    /*
    Checks whether the contents of one collection are the same as another
    collection. Return true if collections contain the same elements.
     */
    public boolean equals(Intcoll4 obj) {

        boolean result = (howmany == obj.howmany);
        ListItem p = c;
        while ((p != null) && (result)) {
            result = obj.belongs(p.info);
            p = p.link;
        }
        return result;
    }

    private class ListItem {

        private int info;
        private ListItem link;

        public ListItem() {
            info = 0;
            link = null;
        }

        public ListItem(int i, ListItem p) {
            info = i;
            link = p;
        }
    }
}
