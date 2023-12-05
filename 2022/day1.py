import re

file = open('2022/inputs/day1.txt', "r")
line = file.readline()

calories = 0
topThree = [0,0,0]
while line:
    if line == "\n" :
        if calories > topThree[0]:
            topThree.pop(0)
            topThree.append(calories)
            topThree.sort()
        calories = 0
    else :
        calories += int(line)
    line = file.readline() # Next line
file.close()
print("=============",topThree[0]+topThree[1]+topThree[2],"=============")