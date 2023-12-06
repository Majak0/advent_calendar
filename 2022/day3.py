# file = open('2022/inputs/day3.txt', "r")
# line = file.readline()

# items = ''
# while line:
#     firstPart, secondPart = line[:len(line)//2], line[len(line)//2:]
#     for char in firstPart :
#         if char in secondPart:
#             print(line,firstPart,"-",secondPart,"=",char,"\n================\n")
#             items = items+char
#             break
#     line = file.readline() # Next line
# file.close()

# priority = 0
# for item in items:
#     if item.isupper():
#         value_to_substract = 38
#     else :
#         value_to_substract = 96
#     priority+=ord(item)-value_to_substract
# print("=============",priority,"=============")

# ====================== day 3 : part 2 ====================== #

file = open('2022/inputs/day3.txt', "r")
line = file.readline()

items = ''
rucksacks = []
while line:
    line = line.replace("\n","")
    if len(rucksacks)<3:
        rucksacks.append(line)
    else :
        temp = []
        for char in rucksacks[0]:
            if char in rucksacks[1]:
                temp.append(char)
        print(temp)
        for item in temp:
           if item in rucksacks[2]:
               items = items+item
               break
        rucksacks.clear()
        rucksacks.append(line)
    line = file.readline() # Next line
file.close()

temp = []
for char in rucksacks[0]:
    if char in rucksacks[1]:
        temp.append(char)
for item in temp:
    if item in rucksacks[2]:
        items = items+item
        break

priority = 0
for item in items:
    if item.isupper():
        value_to_substract = 38
    else :
        value_to_substract = 96
    priority+=ord(item)-value_to_substract
print("=============",priority,"=============")