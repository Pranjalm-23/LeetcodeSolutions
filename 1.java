/*---------------------------------
Brute force
-----------------------------------*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j]==target - nums[i]){
                    ans[0] = i;
                    ans[1] = j; 
                    return ans;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


/*---------------------------------
Single pass and hash
-----------------------------------*/
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();        
        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(map.containsKey(target-x)){
                return new int[] { map.get(target - x), i };
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/*---------------------------------
two times pass and hash
-----------------------------------*/
class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}

/*---------------------------------
Modified Binary Search
-----------------------------------*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0])); // Sort arr in increasing order by their values.
        int left = 0, right = n - 1;
        while (left < right) {
            int sum2 = arr[left][0] + arr[right][0];
            if (sum2 == target)
                return new int[]{arr[left][1], arr[right][1]};
            if (sum2 > target)
                right -= 1; // Try to decrease sum2
            else
                left += 1; // Try to increase sum2
        }
        return new int[]{};
    }
}
