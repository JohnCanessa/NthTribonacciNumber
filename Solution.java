import java.util.Scanner;

/**
 * 1137. N-th Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class Solution {


    /**
     * Given n, return the value of Tn.
     * Requires array initialization.
     */
    static int tribonacci(int n) {

        // **** initialization ****
        int[] t = {0, 1, 1, 0};

        // **** recursive case ****
        return tribRec(n, t);
    }


    /**
     * Given n, return the value of Tn.
     * Recursive call.
     */
    static int tribRec(int n, int[] t) {

        // **** base case ****
        if (n <= 2) {
            return t[n];
        }

        // **** update the array ****
        t[3] = t[0] + t[1] + t[2];
        t[0] = t[1];
        t[1] = t[2];
        t[2] = t[3];

        // **** recursive case (just a counter) ****
        tribRec(n - 1, t);

        // **** return tribonacci of n ****
        return t[2];
    }


    /**
     * Given n, return the value of Tn.
     * Does not require external data.
     * This function is recursive.
     */
    static int tribonacci1(int n) {

        // **** base case(s) ****
        if (n == 0)
            return 0;

        if ((n == 1) || (n == 2))
            return 1;

        // **** recursive case ****
        return tribonacci1(n - 1) + tribonacci1(n - 2) + tribonacci1(n - 3);
    }


    /**
     * Given n, return the value of Tn.
     * Require internal data.
     * This function is iterative.
     */
    static int tribonacci2(int n) {

        // **** base cases ****
        if (n == 0)
            return 0;

        if ((n == 1) || (n == 2))
            return 1;

        // **** to hold tribonacci sequence ****
        int[] t = new int[n + 1];

        // **** initialize array ****
        t[0] = 0;
        t[1] = t[2] = 1;

        // **** loop generating the next value ****
        for (int i = 3; i <= n; i++) {
            t[i] = t[i - 1] + t[i - 2] + t[i - 3];
        }

        // **** return the requested value ****
        return t[n];
    }


    /**
     * Given n, return the value of Tn.
     * This is an initialization function.
     */
    static int tribonacci3(int n) {

        // **** ****
        int[] arr = new int[n + 1];

        // **** recursive call (using a array) ****
        trib(n, arr);

        // **** return tribonacci of n ****
        return arr[n];
    }


    /**
     * Given n, return the value of Tn.
     * This function is recursive.
     */
    static void trib(int n, int[] arr) {

        // **** base cases ****
        if (n == 0)
            arr[n] = 0;

        if ((n == 1) || (n == 2))
            arr[n] = 1;

        // **** recurse (if needed) ****
        if (n > 0) {

            // **** recursive call ****
            trib(n - 1, arr);

            // **** compute current tribonacci element ****
            if (n >= 3)
                arr[n] = arr[n - 1] + arr[n - 2] + arr[n - 3];
        }

    }


    /**
     * Test scaffolding.
     */ 
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read N ****
        int N = sc.nextInt();

        // ???? ????
        System.out.println("main <<< N: " + N);

        // **** close scanner ****
        sc.close();

        // **** loop generating Tn ****
        // for (int n = 0; n <= N; n++) {
        for (int n = N; n <= N; n++) { 

            // **** generate and display Tn ****
            System.out.println("main <<< n: " + n + " Tn: " + tribonacci(n));

            // **** generate and display Tn (recursive; but slow) ****
            System.out.println("main <<< n: " + n + " Tn: " + tribonacci1(n));

            // **** generate and display Tn (iterative) ****
            System.out.println("main <<< n: " + n + " Tn: " + tribonacci2(n));

            // **** generate and display Tn (recursive) ****
            System.out.println("main <<< n: " + n + " Tn: " + tribonacci3(n));
        }

    }

}