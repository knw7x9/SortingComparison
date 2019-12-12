# -*- coding: utf-8 -*-
"""
Created on Mon Sep 16 20:51:56 2019

@author: Katie
"""

import numpy as np
import matplotlib.pyplot as plt

"""Creates an list of lines from the file"""
file_by_line = []

average_time = np.array([])

array_size = np.array([])

"""Opens the text file and creates an array of each line"""
def create_list_of_lines():
    global file_by_line
    file = open('report.csv', 'r')
    file_by_line = file.readlines()

def initialize_array():
    global average_time
    global array_size
    average_time = np.zeros(shape=(7,10))
    array_size = np.zeros(shape=(1,10))

def populate_array():
    global average_time
    
    count = 0
    for i in range(len(file_by_line)):
        if not file_by_line[i][0].isdigit():
            count += 1
        elif (file_by_line[i][0].isdigit()):
            values_in_line = file_by_line[i].split(",")
            for j in range(len(values_in_line)):
                average_time[j][i-count] = values_in_line[j]

def create_graph():
    groups = 10
    
    fig, ax = plt.subplots()
    index = np.arange(groups)
    bar_width = 0.13
    opacity = 0.8
    
    r1 = np.arange(len(average_time[1]))
    r2 = [x + bar_width for x in r1]
    r3 = [x + bar_width for x in r2]
    r4 = [x + bar_width for x in r3]
    r5 = [x + bar_width for x in r4]
    r6 = [x + bar_width for x in r5]
    
    MergeSort = plt.bar(r1, average_time[1], bar_width, alpha=opacity, color='g', label='MergeSort')
    QuickSort = plt.bar(r2, average_time[2], bar_width, alpha=opacity, color='b', label='QuickSort')
    InsertionSort = plt.bar(r3, average_time[3], bar_width, alpha=opacity, color='Orange', label='InsertionSort')
    SelectionSort = plt.bar(r4, average_time[4], bar_width, alpha=opacity, color='r', label='SelectionSort')
    TimSort = plt.bar(r5, average_time[5], bar_width, alpha=opacity, color='Purple', label='TimSort')
    HybridSort = plt.bar(r6, average_time[6], bar_width, alpha=opacity, color='Pink', label='HybridSort')

    plt.xlabel('Array Size')
    plt.ylabel('Nanoseconds')
    plt.title('Sort Comparison')
    plt.xticks(index + bar_width, average_time[0])
    plt.legend()
    
    plt.tight_layout()
    plt.show()
    
def create_sub_graph():
    groups = 10
    
    fig, ax = plt.subplots()
    index = np.arange(groups)
    bar_width = 0.13
    opacity = 0.8
    
    r1 = np.arange(len(average_time[1]))
    r2 = [x + bar_width for x in r1]
    r3 = [x + bar_width for x in r2]
    r4 = [x + bar_width for x in r3]

    
    MergeSort = plt.bar(r1, average_time[1], bar_width, alpha=opacity, color='g', label='MergeSort')
    QuickSort = plt.bar(r2, average_time[2], bar_width, alpha=opacity, color='b', label='QuickSort')
    TimSort = plt.bar(r3, average_time[5], bar_width, alpha=opacity, color='Purple', label='TimSort')
    HybridSort = plt.bar(r4, average_time[6], bar_width, alpha=opacity, color='Pink', label='HybridSort')

    plt.xlabel('Array Size')
    plt.ylabel('Nanoseconds')
    plt.title('Sort Comparison')
    plt.xticks(index + bar_width, average_time[0])
    plt.legend()
    
    plt.tight_layout()
    plt.show()   
    
create_list_of_lines()
initialize_array()
populate_array()
create_graph()
create_sub_graph()