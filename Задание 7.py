from random import randint
A = [randint(-10,10) for i in range(10)]
def zzz(a):
    for i in range(0,9):
        if a[i] < 0 and a[i+1] < 0:
            print(a[i],a[i+1])
def непридумалназвание (b):
    B = []
    for i in range(0,len(b)):
        if B.count(b[i]) < 1:
            B.append(b[i])
    print(B)
print(A)
непридумалназвание(A)
zzz(A)