N = int(input())
def zzz(N):
    A = []
    while N != 0:
        N = N-1
        A.append(int(input()))
    print(sum(A))
zzz(N)