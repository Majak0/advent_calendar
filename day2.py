file = open('inputs/day1.txt', "r")
line = file.readline()

sum = 0
while line:
    line = file.readline() # Next line
file.close()
print("=============",sum,"=============")