import java.util.ArrayList;

public class Permuataion {
    
    static void permute(int[] arr, ArrayList<Integer> list, boolean[] used) {
        if(list.size() == arr.length) {
            System.out.println(list);
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            list.add(arr[i]);
            permute(arr, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr, new ArrayList<>(), new boolean[arr.length]);
    }
}
