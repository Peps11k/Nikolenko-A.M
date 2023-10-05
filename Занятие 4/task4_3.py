x = 50
y = 9
def zzz(a,b):
    A = []
    if a > b:
        for i in range(a,b+1,-1):
            if i%2 != 0:
                A.append(i)
    print(A)
zzz(x,y)