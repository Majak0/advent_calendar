import re 

file = open('inputs/day2.txt', "r")
line = file.readline()

sum = 0
while line:
    isValid = True
    id = int(re.search("[0-9]+",line).group(0))
    line = re.sub("Game [0-9]+:|\n","",line)
    data = line.split(";")
    for value in data:
        cubes = value.split(',')
        for cube in cubes:
            coloredCubed = cube.split()
            match coloredCubed[1]:
                case 'red':
                    if int(coloredCubed[0])>12:
                        isValid=False
                case 'green':
                    if int(coloredCubed[0])>13:
                        isValid=False
                case 'blue':
                    if int(coloredCubed[0])>14:
                        isValid=False
    if isValid:
        sum+=id
    line = file.readline() # Next line
file.close()
print("=============",sum,"=============")