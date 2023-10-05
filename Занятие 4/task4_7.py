a = 3
def zzz(n):
        summ=0
        f=1
        for i in range(1, n+1):
                f = i * f
                summ += f
        print(summ)
zzz(a)