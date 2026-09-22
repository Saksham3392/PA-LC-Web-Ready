
class BubbleSort {

    public static void buubleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length -i - 1; j++) {
                if(arr[j+1] > arr[j]) {   // for asc arr[j] > arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 5};
        buubleSort(arr);
        for(int i = 0;i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}