public class InsertionSort {

    public static void main(String[] args) {

        int[] a = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

        int comparisons = 0;
        int shifts = 0;

        System.out.println("Original:");
        for (int x : a)
            System.out.print(x + " ");

        System.out.println();

        for (int i = 1; i < a.length; i++) {

            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {

                comparisons++;

                a[j + 1] = a[j];
                shifts++;

                j--;
            }

            if (j >= 0)
                comparisons++;

            a[j + 1] = key;

            if (i <= 3) {
                System.out.print("Pass " + i + ": ");

                for (int x : a)
                    System.out.print(x + " ");

                System.out.println();
            }
        }

        System.out.println("Sorted:");
        for (int x : a)
            System.out.print(x + " ");

        System.out.println("\nComparisons: " + comparisons);
        System.out.println("Shifts: " + shifts);
    }
}