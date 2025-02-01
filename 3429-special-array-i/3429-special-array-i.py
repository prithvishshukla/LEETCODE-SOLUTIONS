class Solution:
    def isEven(self, n: int) -> bool:
        return n % 2 == 0
    
    def isOdd(self, n: int) -> bool:
        return n % 2 != 0
    
    def isArraySpecial(self, nums: list[int]) -> bool:
        if len(nums) == 1:
            return True  # Single element is trivially special
        isEvenPattern = self.isEven(nums[0])  # Determine the pattern based on the first element
        for i in range(len(nums)):
            if (i % 2 == 0 and isEvenPattern and not self.isEven(nums[i])) or \
               (i % 2 == 0 and not isEvenPattern and not self.isOdd(nums[i])) or \
               (i % 2 != 0 and isEvenPattern and not self.isOdd(nums[i])) or \
               (i % 2 != 0 and not isEvenPattern and not self.isEven(nums[i])):
                return False  # If any element doesn't match, return false
        return True  # All elements match the pattern, return true