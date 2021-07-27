# -*- coding: utf-8 -*-

import os


class Pytools:

    # get filename list in a directory (no recursion)
    def get_file_list(self, dirPath):

        fileList = []
        if os.path.isfile(dirPath):
            fileList.append(dirPath)
        elif os.path.isdir(dirPath):
            for s in os.listdir(dirPath):
                fullPath = os.path.join(dirPath,s)
                if os.path.isfile(fullPath):
                    fileList.append(fullPath)
        return fileList
    
    def conver_str_to_int(self,item):
        if item == '':
            return 0
        else:
            return int(float(item))

    def convert_str_to_float(self,item):
        if item == '':
            return 0
        else:
            return float(item)