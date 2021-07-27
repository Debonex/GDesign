# -*- coding: utf-8 -*-

import pymysql.cursors
import sys
sys.path.append('..')
from pytools import Pytools

db = pymysql.connect(
    host='localhost', user='root', password='root', database='gdesign', charset='utf8mb4')

pt = Pytools()

commodities = []
with open("../../datasets/commodity_with_value.csv", 'r', encoding='utf-8') as file:
    # first line is titles
    file.readline()
    while(True):
        line = file.readline().strip()
        if len(line) == 0:
            break
        commodity = line.split(',')
        commodities.append({
            "title": commodity[0],
            "specification": commodity[1],
            "value": pt.convert_str_to_float(commodity[2])
        })

cursor = db.cursor()
cursor.execute('select title from commodity;')
db.commit()
titles = list(cursor.fetchall())
titles = list(map(lambda x: x[0], titles))

for com in commodities:
    if com["title"] in titles:
        sql = """update commodity set specification = '%s',value = '%f' where title = '%s'""" %\
            (com["specification"], com["value"], com["title"])
        db.cursor().execute(sql)

db.commit()
db.close()
