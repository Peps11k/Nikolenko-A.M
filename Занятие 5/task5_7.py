x = int(input())
def zzz(a):
    c = 0
    A = []
    A.append(x)
    while a != 0:
        a = int(input())
        A.append(a)
    for i in range (0,len(A)-1):
        if A[i+1] > A[i]:
            c+=1
    print(c)
zzz(x)