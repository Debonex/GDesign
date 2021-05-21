# -*- coding: utf-8 -*-
import csv
import codecs
import xlrd

def xlsx_to_csv():
    workbook = xlrd.open_workbook('../../../stage1/2020.7-12订单.xlsx')
    for i in range(6):
        table = workbook.sheet_by_index(i)
        with codecs.open('../../datasets/orders/%d.csv'%(i+7), 'w', encoding='utf-8') as f:
            write = csv.writer(f)
            for row_num in range(table.nrows):
                row_value = table.row_values(row_num)
                write.writerow(row_value)
 
if __name__ == '__main__':
    xlsx_to_csv()