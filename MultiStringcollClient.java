/*
Maamar Bousseloub
CIS 2168
MultiStringcoll
 */
package multistringcoll;

import java.util.*;

public class MultiStringcollClient {

    public static final String SENTINEL = "###";

    public static void main(String[] args) {
        String str;
        Scanner keyboard = new Scanner(System.in);

        MultiStringcoll P = new MultiStringcoll();
        MultiStringcoll N = new MultiStringcoll();
        MultiStringcoll L = new MultiStringcoll();

        System.out.println("Enter a string to be inserted or ### to quit:");
        str = keyboard.next();

        char[] arr = str.toCharArray();

        while (!(str.equals(SENTINEL))) {
            if (arr[0] != '-') {
                if (arr[0] == '+') {
                    arr = removeSign(arr);
                }
                str = String.valueOf(arr);
                P.insert(str);
                L.insert(str);
            } else {
                arr = removeSign(arr);
                str = String.valueOf(arr);
                N.insert(str);
                L.omit(str);
            }
            System.out.println("Enter next string to be inserted or ### to quit:");
            str = keyboard.next();
            arr = str.toCharArray();
        }
        System.out.println("\nThe values in collection P are:");
        P.print();
        System.out.println("\nThe values in collection N are:");
        N.print();
        System.out.println("\nThe values in collection L are:");
        L.print();
        if (P.equals(N)) {
            System.out.println("\nP and N are equal.");
        } else {
            System.out.println("\nP and N are NOT equal.");
        }
        MultiStringcoll A = new MultiStringcoll();
        A.copy(L);
        System.out.println("\nThe values in the copy of L are:");
        A.print();
    }

    public static char[] removeSign(char[] arr) {
        char[] rem = new char[arr.length - 1];
        for (int i = 0; i < rem.length; i++) {
            rem[i] = arr[i + 1];
        }
        return rem;
    }
}
