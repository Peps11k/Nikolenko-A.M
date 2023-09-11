n = int(input())
m = int(input())
k = int(input())
def chocolate(a,b,c):
    if (a*b-c)%n == 0 or (a*b-c)%m == 0:
        print('Да')
    else:
        print('Нет')
chocolate(n,m,k)