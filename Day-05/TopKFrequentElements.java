import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        for (int num : freqMap.keySet()) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
