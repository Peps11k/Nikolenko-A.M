x = int(input())
def zzz(a):
    c = 0
    b = 0
    b += a
    while a != 0:
        a = int(input())
        c += 1
        b += a
    print(b/c)
zzz(x)