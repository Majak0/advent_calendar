import re

file = open('2022/inputs/day2.txt', "r")
line = file.readline()

score = 0
while line:
    print(line," : ",line[0],line[2])
    match line[0] :
        case 'A':
            if line[2]=="Y":
                score += 8
            elif line[2]=="X":
                score += 4
            else :
                score += 3
        case 'B':
            if line[2]=="Z":
                score += 9
            elif line[2]=="Y":
                score += 5
            else :
                score += 1
        case 'C':
            if line[2]=="X":
                score += 7
            elif line[2]=="Z":
                score += 6
            else :
                score += 2
    line = file.readline() # Next line
file.close()
print("=============",score,"=============")