N = int(input())
K = int(input())
def zzz(a,b):
    f1 = 1
    f2 = 1
    f = 0
    k = 0
    c = 0
    A = []
    B = []
    while c < a:
        k += 1
        if len(A) <= 1:
            A.append(1)
        else:
            f = f1 + f2
            f1 = f2
            f2 = f
            A.append(f)
        if k >= b:
            B.append(A[-1])
            c += 1
    return(sum(B))
print(zzz(N,K))


