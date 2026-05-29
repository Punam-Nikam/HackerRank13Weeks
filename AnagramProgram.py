# import math
# import os
# import random
# import re
# import sys
# from collections import Counter


# def anagram(s):

#     n=len(s);
#     if n%2 !=0:
#         return -1
    
#     s1=s[:n//2]
#     s2=s[n//2:]
    
#     count1=Counter(s1)
#     count2=Counter(s2)
    
#     diff=count1-count2
    
#     return sum(diff.values())
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')
#     q = int(input().strip())
#     for q_itr in range(q):
#         s = input()
#         result = anagram(s)
#         fptr.write(str(result) + '\n')
#     fptr.close()