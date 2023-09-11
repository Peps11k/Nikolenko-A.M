import math
x = 14.26
y = -1.22
z = 3.5*10**-2
s = (2*math.cos(x-2/3))/ (1/2 + (math.sin(y)**2)) * (1 + (z**2)/(3-z**2/5)) #1
print(s)

x =3.74*10**-2
y = -0.825
z = 0.16*10**2
s = (1 + (math.sin(x + y))**2)/ (math.fabs(x - 2*y/(1+ (x**2) * (y**2) ))) * (x**math.fabs(y)) + math.cos((math.atan(1/z)))**2 #3
print(s)


x = 12.3*10**(-1)
y = 15.4
z = 0.252*10**3
s = ((y**(x+1))/ (((math.fabs(y - 2)**(1/3))) + 3)) + ((x + y/2) \
    / (2 * math.fabs(x + y))) * (x + 1)**(-1/math.sin(z))
print(s)