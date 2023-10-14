N = int(input())
def zzz (a):
    i = 2
    c = 0
    while i * 2 <= a:
         i *= 2
         c += 1
    print(c, i)
zzz(N)