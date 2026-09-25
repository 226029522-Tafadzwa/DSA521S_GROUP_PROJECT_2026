public class SelectionSort {

    public static void main(String[] args) {

        int[] a = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

        int comparisons = 0;
        int swaps = 0;

        System.out.println("Original:");
        for (int x : a)
            System.out.print(x + " ");

        System.out.println();

        for (int i = 0; i < a.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < a.length; j++) {

                comparisons++;

                if (a[j] < a[min])
                    min = j;
            }

            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;

                swaps++;
            }

            if (i < 3) {
                System.out.print("Pass " + (i + 1) + ": ");

                for (int x : a)
                    System.out.print(x + " ");

                System.out.println();
            }
        }

        System.out.println("Sorted:");
        for (int x : a)
            System.out.print(x + " ");

        System.out.println("\nComparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }
}