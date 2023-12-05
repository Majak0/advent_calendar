import re

file = open('2022/inputs/day2.txt', "r")
line = file.readline()

# score = 0
# while line:
#     match line[0] :
#         case 'A':
#             if line[2]=="Y":
#                 score += 8
#             elif line[2]=="X":
#                 score += 4
#             else :
#                 score += 3
#         case 'B':
#             if line[2]=="Z":
#                 score += 9
#             elif line[2]=="Y":
#                 score += 5
#             else :
#                 score += 1
#         case 'C':
#             if line[2]=="X":
#                 score += 7
#             elif line[2]=="Z":
#                 score += 6
#             else :
#                 score += 2
#     line = file.readline() # Next line
# file.close()
# print("=============",score,"=============")

# ====================== day 1 : part 2 ====================== #

score = 0
while line:
    match line[2] :
        case 'X': # You need to lose
            if line[0]=="A":
                score += 3
            elif line[0]=="B":
                score += 1
            else :
                score += 2
        case 'Y': # You need to draw
            if line[0]=="A":
                score += 4
            elif line[0]=="B":
                score += 5
            else :
                score += 6
        case 'Z': # You need to win
            if line[0]=="A":
                score += 8
            elif line[0]=="B":
                score += 9
            else :
                score += 7
    line = file.readline() # Next line
file.close()
print("=============",score,"=============")