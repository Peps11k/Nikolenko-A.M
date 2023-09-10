seconds = int(input())
m = seconds/ 60
seconds = seconds % 60
h = m / 60
m = m % 60
d = h / 24
h = h % 24
print(seconds, m, h, d)