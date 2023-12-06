import math

file = open('2023/inputs/day6.txt', "r")

# Get all the times
line = file.readline()
times = line.split()
times.pop(0)

# Get all the distances
line = file.readline()
distances = line.split()
distances.pop(0)
file.close()

res = 1
for i, time in enumerate(times):
    num = 0
    time = int(time)
    for charge in range(time + 1):
        if (time - charge) * charge > int(distances[i]):
            num += 1
    res *= num
print("=============",res,"=============")

# ====================== day 6 : part 2 ====================== #

time = int(''.join(times))
distance = int(''.join(distances))


# Quadratic equation
temp = math.sqrt(time**2 - 4*distance)
c2 = (time + temp) / 2
c1 = (time - temp) / 2
print("=============",int(c2) - int(math.ceil(c1)) + 1,"=============")