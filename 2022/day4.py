# file = open('2022/inputs/day4.txt', "r")
# line = file.readline()
# pairs = 0
# while line:
#     line = line.replace("\n","")
#     print(line,':',pairs)
#     datas = line.split(',')
#     firstElf = datas[0].split('-')
#     secondElf = datas[1].split('-')
    
#     list1 = []
#     list2 = []
#     for num in range(int(firstElf[0]),int(firstElf[-1])+1):
#         list1.append(num)
#     print(list1)
#     for num in range(int(secondElf[0]),int(secondElf[-1])+1):
#         list2.append(num)
#     print(list2,"\n==================\n")
#     if all(item in list1 for item in list2) or all(item in list2 for item in list1):
#         pairs+=1
#         print(pairs)
#     line = file.readline() # Next line
# file.close()
# print("=============",pairs,"=============")

# ====================== day 4 : part 2 ====================== #

file = open('2022/inputs/day4.txt', "r")
line = file.readline()
pairs = 0
while line:
    line = line.replace("\n","")
    print(line,':',pairs)
    datas = line.split(',')
    firstElf = datas[0].split('-')
    secondElf = datas[1].split('-')
    
    list1 = []
    list2 = []
    for num in range(int(firstElf[0]),int(firstElf[-1])+1):
        list1.append(num)
    print(list1)
    for num in range(int(secondElf[0]),int(secondElf[-1])+1):
        list2.append(num)
    print(list2,"\n==================\n")
    if any(item in list1 for item in list2) or any(item in list2 for item in list1):
        pairs+=1
        print(pairs)
    line = file.readline() # Next line
file.close()
print("=============",pairs,"=============")