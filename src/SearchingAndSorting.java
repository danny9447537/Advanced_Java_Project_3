import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SearchingAndSorting {
    public static void main(String[] args) {

        ArrayList<Integer> insertionSortList = new ArrayList<>(); // arraylist for insertion sort
        ArrayList<Integer> quickSortList = new ArrayList<>(); // arraylist for insertion sort


        Random rand = new Random(); //new random object
        for (int i = 0 ; i < 3 ; i++) {
            insertionSortList.add(rand.nextInt()); // filling arraylist with 10 random integers
            quickSortList.add(rand.nextInt()); // filling arraylist with 10 random integers
        }

        System.out.println(insertionSortList);

        insertionSort(insertionSortList);

        System.out.println(insertionSortList);
        System.out.println();

        System.out.println(quickSortList);

        quicksort(quickSortList);

        System.out.println(quickSortList);


    }




    public static void quicksort(ArrayList<Integer> numbers){
        quicksort(numbers, 0, numbers.size()-1);
    }

    public static void quicksort(ArrayList<Integer> numbers, int i, int k) {
        int j;

      /* Base case: If there are 1 or zero entries to sort,
       partition is already sorted */
        if (i >= k) {
            return;
        }

      /* Partition the data within the array. Value j returned
         from partitioning is location of last item in low partition. */
        j = partition(numbers, i, k);

      /* Recursively sort low partition (i to j) and
         high partition (j + 1 to k) */
        quicksort(numbers, i, j);
        quicksort(numbers, j + 1, k);
    }

    public static int partition(ArrayList<Integer> numbers, int i, int k) {
        int l;
        int h;
        int midpoint;
        int pivot;
        int temp;
        boolean done;

        /* Pick middle element as pivot */
        midpoint = i + (k - i) / 2;

        pivot = numbers.get(midpoint);
        //pivot = numbers[midpoint];

        done = false;
        l = i;
        h = k;

        while (!done) {
            /* Increment l while numbers[l] < pivot */
            //while (numbers[l] < pivot) {
            while(numbers.get(l) < pivot){
                ++l;
            }

            /* Decrement h while pivot < numbers[h] */
            while (pivot < numbers.get(h)) {
                --h;
            }

         /* If there are zero or one items remaining,
            all numbers are partitioned. Return h */
            if (l >= h) {
                done = true;
            }
            else {
            /* Swap numbers[l] and numbers[h],
               update l and h */
                //temp = numbers[l];
                temp = numbers.get(l);

                //numbers[l] = numbers[h];
                numbers.set(l, numbers.get(h));

                //numbers[h] = temp;
                numbers.set(h, temp);


                ++l;
                --h;
            }
        }

        return h;
    }

    public static void insertionSort(ArrayList<Integer> myList) {
        for (int i = 0 ; i < myList.size() ; i++) {
            int j = i;
            while (j > 0 && (myList.get(j - 1) > myList.get(j))) {
                int temp = myList.get(j);
                myList.set(j, myList.get(j-1));
                myList.set(j-1, temp);

                j--;
            }
        }
    }

    public static void insertionSort2(ArrayList<Integer> myList) {
        int i;
        int j;
        int indexSmallest;
        int temp;

        for (i = 0; i < myList.size() -1; i++) {
            indexSmallest = i;
            for (j = i + 1; j <myList.size(); j++) {
                if (myList.get(j) < myList.get(indexSmallest)) {
                    indexSmallest = j;
                }
            }
            temp = myList.get(i);
            myList.set(i, myList.get(indexSmallest));
            myList.set(indexSmallest, temp);
        }

    }

}