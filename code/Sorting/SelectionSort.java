import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 7};
        int k = 3;
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[k-1]);
    }
}
