# # WEEK TEST - 4
# Given a string, divide it into two equal halves. Determine the minimum number of character changes required in the first half to make it an anagram of the second half. If the string length is odd, return -1.

from collections import Counter

def anagram(s):

    n = len(s)

    if n % 2 != 0:
        return -1

    s1 = s[:n//2]
    s2 = s[n//2:]

    count1 = Counter(s1)
    count2 = Counter(s2)

    diff = count1 - count2

    return sum(diff.values())


q = int(input())

for _ in range(q):
    s = input()
    print(anagram(s))