package neetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequency {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] r = topKFrequent(nums, 2);
        System.out.println(r);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }
        return frequency.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(i->i)
                .toArray();

    }

}
