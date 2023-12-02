import re

file = open('inputs/day1.txt', "r")
line = file.readline()

sum = 0
while line:
    line = ''.join(re.findall(r'\d+', line)) #delete non numeric chars
    add = line[0] + line[-1] #Create number from first and last digit of string
    sum += int(add)
    line = file.readline() #next line
file.close()
print("=========  ",sum,"  ==========")