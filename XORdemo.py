##Problem - 21 XOR Strings
# Given two binary strings (strings containing only 0 and 1) of equal length, perform the XOR operation on each corresponding pair of characters
#  and return the resulting binary string.

def strings_xor(s, t):
    res = ""
    for i in range(len(s)):
        if s[i] == t[i]:
            res += '0';
        else:
            res += '1';

    return res

s = input()
t = input()
print(strings_xor(s, t))
