n = int(input())
h = n//60
m = n%60
if n < 60*24:
    print(h, m)
else:
    print('Введене неверное количество минут')