import re

file = open('2023/inputs/day4.txt', "r")
line = file.readline()

sum = 0
while line:
    points = 0.5
    line = re.sub("Card [0-9]+:|\n","",line)
    data = line.split('|')
    winningNumbers = data[0].split()
    yourNumbers = data[1].split()
    for number in yourNumbers :
        if number in winningNumbers :
            points*=2
    if points != 0.5 :
        sum += points
    line = file.readline() # Next line
file.close()
print("=============",int(sum),"=============")