from os.path import exists as file_exists
from traceback import print_tb

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
title += header + " Sort ("
footer_title = "): "

x = np.array(content[1])

n = len(content)
start = 2
footer = [None] * (n - start)

for i in range(start, n):    
    footer[i-start] = content[i].pop(0)

for i in range(len(footer)):
    plotName = plt.figure(footer[i] + " Case")
    plt.title(title + footer[i] + footer_title)
    y = np.array(content[i+start])
    plt.xticks(rotation=45, ha='right')
    plt.plot(x,y, c=next(cycol))

plt.show()



# # Import pandas package 
# from matplotlib import pyplot as plt
# import pandas as pd 
# data = pd.read_csv("src/RadixTotalGraphData.csv")
# data_top = list(data.columns)

# y = data[data.columns[0]].to_numpy()

# n = 5000
# x = [x*n for x in range(0,len(y))]
# print(x[29])
# plt.plot(x,y)
# plt.show()

# # # making data frame 
# # data_top = data.head() 

# # # iterating the columns
# # print(data_top)

