import re
# ====================== part 2 ====================== #

words = {
    'zero' : '0',
    'one' : '1',
    'two' : '2',
    'three' : '3',
    'four' : '4',
    'five' : '5',
    'six' : '6',
    'seven' : '7',
    'eight' : '8',
    'nine' : '9'
}

file = open('inputs/day1.txt', "r")
line = file.readline()
sum = 0
while line:
    index = 0
    while index < len(line):
        for word in words :
            if index+len(word) >= len(line)-index :
                if line[index:]==word:
                    line = line.replace(word, words[word],1)
            else :
                if line[index:index+len(word)]==word:
                    line = line.replace(word, words[word],1)
        index+=1
    print(line)
    line = ''.join(re.findall(r'\d+', line)) # Delete non numeric chars
    add = line[0] + line[-1] # Create number from first and last digit of string
    print(line," - ",line[0]," - ",line[-1]," : ",add,"\n------------------------\n")
    sum += int(add)
    line = False
    line = file.readline() # Next line
file.close()