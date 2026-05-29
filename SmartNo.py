# PROBLEM - 36 SMART NUMBER

# A number is called a Smart Number if it has an odd number of factors.
# Given multiple numbers, determine whether each number is a Smart Number and print "YES" or "NO" accordingly.
# hint: A number is a Smart Number if and only if it is a perfect square.

import math

def is_smart_number(num):
    val = int(math.sqrt(num))
    if num / val == val:
        return True
    return False

for _ in range(int(input())):
    num = int(input())
    ans = is_smart_number(num)
    if ans:
        print("YES")
    else:
        print("NO")
