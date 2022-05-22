from os.path import exists as file_exists

# Importing packages
import matplotlib.pyplot as plt
import numpy as np
from itertools import cycle
#list of 6 colour only
cycol = cycle('bgrcmk')

name = "Radix"
txt_name = name + "TotalGraphData.txt"
if (file_exists(txt_name) == False):
    txt_name = "src/" + txt_name
    if (file_exists(txt_name) == False):
        print("File not found")
        exit()

with open(txt_name, "r") as textFile:
    content = [content.split() for content in textFile]

title = ""
header = ""

header = header.join(content[0])
title += header + " Sort"

print(title)
x = np.array(content[1])


n = len(content)
start = 2
legend = [None] * (n - start)

for i in range(start, n):    
    legend[i-start] = content[i].pop(0)

plt.figure(title)
plt.title(title)

for i in range(start, n):

    if (i == 4):
        continue

plt.plot(x, content[i], c=next(cycol), label=legend[i-start])

plt.xticks(rotation=45, ha='right')

plt.legend()
plt.show()
