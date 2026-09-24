import java.util.Random;

public class PartC
{
    static long comparisons = 0;

    // 1. Generate an array
    static int[] generateArray(int size)
    {
        int[] array = new int[size];

        Random random = new Random();

        for(int i = 0; i < size; i++)
        {
            array[i] = random.nextInt(1000) + 1;
        }

        return array;
    }

    // 2. Create the almost-sorted array
    static int[] createAlmostSortedArray(int[] original)
    {
        int[] array = original.clone();

        // First sort the array
        comparisons = 0;
        selectionSort(array);

        // Swap five pairs of neighbouring values
        int temp;

        temp = array[10];
        array[10] = array[11];
        array[11] = temp;

        temp = array[30];
        array[30] = array[31];
        array[31] = temp;

        temp = array[50];
        array[50] = array[51];
        array[51] = temp;

        temp = array[70];
        array[70] = array[71];
        array[71] = temp;

        temp = array[90];
        array[90] = array[91];
        array[91] = temp;

        return array;
    }

    // 3. Selection Sort
    static void selectionSort(int[] array)
    {
        int n = array.length;

        for(int i = 0; i < n - 1; i++)
        {
            int min = i;

            for(int j = i + 1; j < n; j++)
            {
                comparisons++;

                if(array[j] < array[min])
                {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    // 4. Insertion Sort
    static void insertionSort(int[] array)
    {
        int n = array.length;

        for(int i = 1; i < n; i++)
        {
            int temp = array[i];
            int j = i - 1;

            while(j >= 0)
            {
                comparisons++;

                if(array[j] > temp)
                {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                else
                {
                    break;
                }
            }

            array[j + 1] = temp;
        }
    }

    // 5. Merge Sort
    static void mergeSort(int[] array, int lb, int ub)
    {
        if(lb < ub)
        {
            int mid = (lb + ub) / 2;

            mergeSort(array, lb, mid);
            mergeSort(array, mid + 1, ub);

            merge(array, lb, mid, ub);
        }
    }

    static void merge(int[] array, int lb, int mid, int ub)
    {
        int[] newArray = new int[array.length];

        int i = lb;
        int j = mid + 1;
        int k = lb;

        while(i <= mid && j <= ub)
        {
            comparisons++;

            if(array[i] <= array[j])
            {
                newArray[k] = array[i];
                i = i + 1;
            }
            else
            {
                newArray[k] = array[j];
                j = j + 1;
            }

            k = k + 1;
        }

        if(i > mid)
        {
            while(j <= ub)
            {
                newArray[k] = array[j];
                j = j + 1;
                k = k + 1;
            }
        }
        else
        {
            while(i <= mid)
            {
                newArray[k] = array[i];
                i = i + 1;
                k = k + 1;
            }
        }

        for(k = lb; k <= ub; k++)
        {
            array[k] = newArray[k];
        }
    }

    // 6. Quick Sort
    static void quickSort(int[] array, int start, int end)
    {
        if(start < end)
        {
            int pivot = start;
            int i = start;
            int j = end;

            while(i < j)
            {
                while(i < end)
                {
                    comparisons++;

                    if(array[i] <= array[pivot])
                    {
                        i = i + 1;
                    }
                    else
                    {
                        break;
                    }
                }

                while(j > start)
                {
                    comparisons++;

                    if(array[j] > array[pivot])
                    {
                        j = j - 1;
                    }
                    else
                    {
                        break;
                    }
                }

                if(i < j)
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[pivot];
            array[pivot] = array[j];
            array[j] = temp;

            quickSort(array, start, j - 1);
            quickSort(array, j + 1, end);
        }
    }

    // 7. Run the experiment for one array size
    static void runExperiment(int size)
    {
        // Generate ONE original array
        int[] original = generateArray(size);

        // Make copies of the SAME original array
        int[] selectionArray = original.clone();
        int[] insertionArray = original.clone();
        int[] mergeArray = original.clone();
        int[] quickArray = original.clone();

        System.out.println();
        System.out.println("====================================");
        System.out.println("Array Size: " + size);
        System.out.println("====================================");

        // Selection Sort
        comparisons = 0;

        long start = System.nanoTime();

        selectionSort(selectionArray);

        long end = System.nanoTime();

        System.out.println("Selection Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + (end - start) + " ns");

        // Insertion Sort
        comparisons = 0;

        start = System.nanoTime();

        insertionSort(insertionArray);

        end = System.nanoTime();

        System.out.println("Insertion Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + (end - start) + " ns");

        // Merge Sort
        comparisons = 0;

        start = System.nanoTime();

        mergeSort(mergeArray, 0, mergeArray.length - 1);

        end = System.nanoTime();

        System.out.println("Merge Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + (end - start) + " ns");

        // Quick Sort
        comparisons = 0;

        start = System.nanoTime();

        quickSort(quickArray, 0, quickArray.length - 1);

        end = System.nanoTime();

        System.out.println("Quick Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    // 8. Run the almost-sorted experiment
    static void runAlmostSortedExperiment()
    {
        int[] original = generateArray(100);

        int[] almostSorted = createAlmostSortedArray(original);

        // Give every algorithm the SAME almost-sorted array
        int[] selectionArray = almostSorted.clone();
        int[] insertionArray = almostSorted.clone();
        int[] mergeArray = almostSorted.clone();
        int[] quickArray = almostSorted.clone();

        System.out.println();
        System.out.println("====================================");
        System.out.println("Almost-Sorted Array Size: 100");
        System.out.println("====================================");

        // Selection Sort
        comparisons = 0;

        long start = System.nanoTime();

        selectionSort(selectionArray);

        long end = System.nanoTime();

        System.out.println("Selection Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + (end - start) + " ns");

        // Insertion Sort
        comparisons = 0;

        start = System.nanoTime();

        insertionSort(insertionArray);

        end = System.nanoTime();

        System.out.println("Insertion Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + (end - start) + " ns");

        // Merge Sort
        comparisons = 0;

        start = System.nanoTime();

        mergeSort(mergeArray, 0, mergeArray.length - 1);

        end = System.nanoTime();

        System.out.println("Merge Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + (end - start) + " ns");

        // Quick Sort
        comparisons = 0;

        start = System.nanoTime();

        quickSort(quickArray, 0, quickArray.length - 1);

        end = System.nanoTime();

        System.out.println("Quick Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    // Main method
    public static void main(String[] args)
    {
        runExperiment(20);

        runExperiment(50);

        runExperiment(100);

        runExperiment(500);

        runAlmostSortedExperiment();
    }
}