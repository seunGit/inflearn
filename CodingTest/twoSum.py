# list - twoSum 문제

# 반복문
def twoSum(nums, target):
    n = len(nums)
    for i in range(n):
        for j in range(i+1, n):
            if nums[i] + nums[j] == target:
                return True
    return False

print(twoSum(nums = [2,1,4,7], target=4))

# TwoPointer
def twoSum(nums, target):
    nums.sort()
    l, r = 0, len(nums)-1
    while l < r:
        if nums[l] + nums[r] > target:
            r = r-1
        elif nums[l] + nums[r] < target:
            l = l+1
        elif nums[l] + nums[r] == target:
            return True
    return False

print(twoSum(nums = [1, 3, 4, 5, 7, 9, 16], target=14))