package multistringcoll;

import java.util.*;

public class MultiStringcoll {

    private btNode c;
    private int howmany;

    private static class btNode {

        private String info;
        private btNode left;
        private btNode right;
        int count;

        public btNode() {
            info = null;
            left = null;
            right = null;
            count = 1;
        }

        public btNode(String i, btNode lt, btNode rt) {
            info = i;
            left = lt;
            right = rt;
            count = 1;
        }
    }

    /*
    Constructor without a parameter that finds storage capacity
    and ensures that c is empty.
     */
    public MultiStringcoll() {
        c = null;
        howmany = 0;
    }

    /*
    Constructor with an int parameter that finds storage capacity
    for int i and ensures that c is empty.
     */
    public MultiStringcoll(int i) {
        c = null;
        howmany = 0;
    }

    /*
    Make collection 'this' have the same capacity as collection of
    object and contain the exact same elements as those of object.
     */
    public void copy(MultiStringcoll obj) {
        if (this != obj) {
            howmany = obj.howmany;
            c = copytree(obj.c);
        }
    }

    /*
    Uses recursion to copy a tree
     */
    private static btNode copytree(btNode t) {
        btNode result = null;
        if (t != null) {
            result = new btNode();
            result.info = t.info;
            result.left = copytree(t.left);
            result.right = copytree(t.right);
        }
        return result;
    }

    /*
    Checks if value i is in the collection. Return true if it is.
     */
    public boolean belongs(String i) {
        btNode p = c;
        while ((p != null) && !(p.info.equals(i))) {
            if (0 < p.info.compareTo(i)) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (p != null);
    }

    /*
    Inserts an int into the collection. Do nothing if int already exists.
     */
    public void insert(String i) {
        btNode p = c;
        btNode pred = null;

        while ((p != null) && !(p.info.equals(i))) {
            pred = p;
            if (0 < p.info.compareTo(i)) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            howmany++;
            p = new btNode(i, null, null);
            if (pred != null) {
                if (0 < pred.info.compareTo(i)) {
                    pred.left = p;
                } else {
                    pred.right = p;
                }
            } else {
                c = p;
            }
        } else {
            p.count++;
        }
    }

    /*
    Removes an int from the collection if it exists. Do nothing if not.
     */
    public void omit(String i) {
        btNode p = c;
        btNode pred = null;
        while ((p != null) && !(p.info.equals(i))) {
            pred = p;
            if (0 < p.info.compareTo(i)) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if ((p != null) && (p.count == 1)) {
            howmany--;
            //leaf node
            if ((p.left == null) && (p.right == null)) {
                if (pred != null) {
                    if (0 < pred.info.compareTo(i)) {
                        pred.left = null;
                    } else {
                        pred.right = null;
                    }
                } else {
                    c = null; //root is the only node
                }
            } //null left subtree, non-null right subtree
            else if ((p.left == null) && (p.right != null)) {
                if (pred != null) {
                    if (0 < pred.info.compareTo(i)) {
                        pred.left = p.right;
                    } else {
                        pred.right = p.right;
                    }
                } else {
                    c = p.right; //root with right subtree
                }
            } //non-null left subtree, null right subtree
            else if ((p.left != null) && (p.right == null)) {
                if (pred != null) {
                    if (0 < pred.info.compareTo(i)) {
                        pred.left = p.left;
                    } else {
                        pred.right = p.left;
                    }
                } else {
                    c = p.left; //root with left subtree
                }
            } //non-null left subtree, non-null right subtree
            else if ((p.left != null) && (p.right != null)) {
                btNode q = p.left;
                btNode qPred = p;
                if (pred != null) {

                    //search tree to find new node to replace one being removed
                    while (q.right != null) {
                        qPred = q;
                        q = q.right; //largest member in right subtree of left sub tree of p
                    }
                    if (qPred != p) {
                        qPred.right = q.left;
                    } else {
                        qPred.left = null;
                    }
                    q.left = p.left;
                    q.right = p.right;
                    if (0 < pred.info.compareTo(p.info)) {
                        pred.left = q;
                    } else {
                        pred.right = q;
                    }

                } //root with both children
                else {
                    //search tree to find new node to replace one being removed
                    while (q.right != null) {
                        qPred = q;
                        q = q.right; //largest member in right subtree of left sub tree of p
                    }
                    if (qPred != p) {
                        qPred.right = q.left;
                    } else {
                        p.left = q.left;
                    }
                    q.left = p.left;
                    q.right = p.right;
                    if (0 < c.info.compareTo(p.info)) {
                        c = q;
                    } else {
                        c = q;
                    }
                }
            }
        } else if (p != null) {
            if (p.count > 1) {
                p.count--;
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
        printtree(c);
    }

    /*
    Prints tree, uses in-order traveral of the tree
     */
    private static void printtree(btNode t) {
        if (t != null) {
            printtree(t.left);
            if (t.count > 1) {
                System.out.println(t.info + "(" + t.count + ")");
            } else {
                System.out.println(t.info);
            }
            printtree(t.right);
        }
    }

    /*
    Checks whether the contents of one collection are the same as another
    collection. Return true if collections contain the same elements.
     */
    public boolean equals(MultiStringcoll obj) {
        boolean result = (howmany == obj.howmany);
        int j = 0;
        if (result) {
            //create arrays a and b with element count howmany
            String[] a = new String[howmany];
            String[] b = new String[howmany];
            /*use toarray function to do inorder traversal of the objects
             being compared, enter the values found in those objects
             into arrays a and b respectively */
            toarray(c, a, 0);
            toarray(obj.c, b, 0);

            while ((result) && (j < howmany)) {
                //compare arrays a and b, then compare that to result
                result = ((a[j].equals(b[j])));
                j++;
            }
        }
        return result;
    }

    /*
    Uses in-order traversal to place integers in tree into an array
     */
    private static int toarray(btNode t, String[] a, int i) {
        int num_nodes = 0;
        if (t != null) {
            num_nodes = toarray(t.left, a, i);
            a[num_nodes + i] = t.info + t.count;
            num_nodes = num_nodes + 1 + toarray(t.right, a, num_nodes + i + 1);
        }
        return num_nodes;
    }

    public int get_total() {
        return c.count;
    }
}
