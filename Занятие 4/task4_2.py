x = 9
y = 64
def zzz(a,b):
    A = []
    if a < b:
        for i in range(a,b+1):
            A.append(i)
    else:
        for j in range(b,a+1):
            A.append(j)
        A.reverse()
    print(A)
zzz(x,y)