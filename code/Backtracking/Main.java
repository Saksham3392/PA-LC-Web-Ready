import java.util.ArrayList;

class Main {

    static void subseq(int[] arr, int index, ArrayList<Integer>list) {
        if(index==arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        subseq(arr, index+1, list);
        list.remove(list.size() - 1); 
        subseq(arr, index+1, list);
    }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3};
            subseq(arr, 0, new ArrayList<>());
    }
}