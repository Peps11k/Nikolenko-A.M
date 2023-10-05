N = int(input())
def zzz(a):
    f1 = 1
    f2 = 1
    f = 0
    c = 0
    A = [1,1]
    while c < a-2:
        f = f1 + f2
        A.append(f)
        f1 = f2
        f2 = f
        c += 1
    return (sum(A))
print(zzz(N))