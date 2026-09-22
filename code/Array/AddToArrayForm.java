package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> list = new ArrayList<>();
            int i = num.length - 1;
            

            while (i >= 0 || k > 0) {
                if (i >= 0) {
                    k += num[i];
                    i--;
                }
                
                list.add(k % 10);
                k /= 10;
            }
            
            Collections.reverse(list);
            
            return list;
        }
    }
}