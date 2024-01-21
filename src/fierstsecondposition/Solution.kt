package fierstsecondposition

internal class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val f = first(nums,target)
        val s = second(nums,target)

        return intArrayOf(f, s)
    }

    fun first(nums: IntArray, target: Int): Int {
        var left = 0
        var index = -1
        var right=nums.size-1
        while(left <= right){
            val mid = left + (right - left) / 2
            if(nums[mid] == target){
                index = mid
                right = mid  -1
            }
            else if(nums[mid] > target){
                right = mid  - 1
            }else {
                left = mid + 1
            }
        }
        return index
    }

    fun second(nums: IntArray, target: Int): Int {
        var left = 0
        var index = -1
        var right=nums.size-1
        while(left <= right){
            val mid = left + (right - left) / 2
            if(nums[mid] == target){
                index = mid;
                left = mid   +1
            }
            else if(nums[mid] > target){
                right = mid  - 1
            }else {
                left = mid + 1
            }
        }
        return index
    }
}