public class SortPeople {
    
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        java.util.Map<Integer, String> map = new java.util.HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        java.util.Arrays.sort(heights);

        String[] result = new String[n];
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            result[index] = map.get(heights[i]);
            index++;
        }

        return result;
    }
}