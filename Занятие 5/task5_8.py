x = int(input())
def zzz(a):
    c = 0
    m = 0
    A = []
    B = []
    A.append(x)
    while a != 0:
        a = int(input())
        A.append(a)
    for i in range (0,len(A)-1):
        if A[i] == A[i+1]:
            B.append(A[i])
    for i in range(0,len(B)):
        if B.count(A[i]) >= B.count(A[i+1]):
            m = B.count(A[i])
    print(m+1)
zzz(x)