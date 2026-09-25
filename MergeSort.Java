public class MergeSort {

    public static void main(String[] args) {

        int[] a = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

        System.out.println("Original:");
        for (int x : a)
            System.out.print(x + " ");

        System.out.println();

        mergeSort(a, 0, a.length - 1);

        System.out.println("Sorted:");
        for (int x : a)
            System.out.print(x + " ");
    }

    static void mergeSort(int[] a, int left, int right) {

        if (left >= right) {
            System.out.println("Base case: " + a[left]);
            return;
        }

        int mid = (left + right) / 2;

        System.out.print("Divide: ");
        for (int i = left; i <= right; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= mid)
            temp[k++] = a[i++];

        while (j <= right)
            temp[k++] = a[j++];

        for (i = 0; i < temp.length; i++)
            a[left + i] = temp[i];

        System.out.print("Merge: ");
        for (i = left; i <= right; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }
}