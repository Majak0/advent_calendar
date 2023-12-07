import re

file = open('2020/inputs/day2.txt', "r")
line = file.readline()

validPasswords = 0
while line:
    line = line.replace(':', '')
    data = line.split()
    indexes = data[0].split('-')
    if(data[2].count(data[1]) >= int(indexes[0]) and data[2].count(data[1]) <= int(indexes[1])): validPasswords+=1
    line = file.readline() # Next line
file.close()
print("=============",validPasswords,"=============")

# ====================== day 2 : part 2 ====================== #

import re

file = open('2020/inputs/day2.txt', "r")
line = file.readline()

validPasswords = 0
while line:
    line = line.replace(':', '')
    data = line.split()
    indexes = data[0].split('-')
    if(data[2][int(indexes[0])-1] == data[1] and data[2][int(indexes[1])-1] != data[1]): validPasswords+=1
    elif(data[2][int(indexes[0])-1] != data[1] and data[2][int(indexes[1])-1] == data[1]): validPasswords+=1
    line = file.readline() # Next line
file.close()
print("=============",validPasswords,"=============")