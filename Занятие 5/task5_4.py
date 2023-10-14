x = int(input())
y = int(input())
def zzz(a,b):
    c = 0
    while a < b:
        a = a + (a / 100 * 10)
        c +=1
    print(c)
zzz(x,y)