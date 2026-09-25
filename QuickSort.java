public class QuickSort {

    static int count = 0;

    public static void main(String[] args) {

        int[] a = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

        System.out.println("Original:");
        for (int x : a)
            System.out.print(x + " ");

        System.out.println();

        quickSort(a, 0, a.length - 1);

        System.out.println("Sorted:");
        for (int x : a)
            System.out.print(x + " ");
    }

    static void quickSort(int[] a, int low, int high) {

        if (low < high) {

            int pivot = a[high];

            int i = low - 1;

            for (int j = low; j < high; j++) {

                if (a[j] < pivot) {

                    i++;

                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

            int temp = a[i + 1];
            a[i + 1] = a[high];
            a[high] = temp;

            int position = i + 1;

            count++;

            if (count <= 2) {

                System.out.println("\nPartition " + count);
                System.out.println("Pivot: " + pivot);

                System.out.print("Left: ");

                for (int j = low; j < position; j++)
                    System.out.print(a[j] + " ");

                System.out.println();

                System.out.print("Right: ");

                for (int j = position + 1; j <= high; j++)
                    System.out.print(a[j] + " ");

                System.out.println();
            }

            quickSort(a, low, position - 1);
            quickSort(a, position + 1, high);
        }
    }
}