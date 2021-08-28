# -*- coding: utf-8 -*-
import pymysql.cursors
import os
import json
import math
from conf.config import getConfig

mc = getConfig().mysql


def pearson(u1, u2):
    num = 0
    xy, x, y, x2, y2 = 0, 0, 0, 0, 0
    for key in u1:
        if key in u2:
            num += 1
            x += u1[key]
            y += u2[key]
            xy += u1[key] * u2[key]
            x2 += math.pow(u1[key], 2)
            y2 += math.pow(u2[key], 2)
    if num == 0:
        return 0
    denominator = math.sqrt(x2 - math.pow(x, 2) / num) * math.sqrt(y2 - math.pow(y, 2) / num)
    if denominator == 0:
        return 0
    return (xy - x * y / num) / denominator


class ContentBase:

    def __init__(self, trainPath, testPath):
        self.trainPath = trainPath
        self.testPath = testPath
        self.train = {}
        self.test = {}
        self.connection = pymysql.connect(
            host=mc.get("host"), user=mc.get("user"), password=mc.get("password"), database=mc.get("database"),
            charset=mc.get("charset"))
        self.load_data()

    def save_data(self):
        if os.path.exists(self.trainPath) and os.path.exists(self.testPath):
            return
        train = {}
        test = {}
        # 数据库连接

        with self.connection.cursor() as cursor:
            sql = """select id_order,uid,id_commodity,num_commodity from orders"""
            cursor.execute(sql)
            results = cursor.fetchall()
            for row in results:
                # 测试集
                if (row[0][5:7] == "12") or (row[0][5:7] == "11"):
                    if row[1] in test:
                        if row[2] in test[row[1]]:
                            test[row[1]][row[2]] = test[row[1]][row[2]] + row[3]
                        else:
                            test[row[1]][row[2]] = row[3]
                    else:
                        test[row[1]] = {row[2]: row[3]}
                # 训练集
                else:
                    if row[1] in train:
                        if row[2] in train[row[1]]:
                            train[row[1]][row[2]] = train[row[1]][row[2]] + row[3]
                        else:
                            train[row[1]][row[2]] = row[3]
                    else:
                        train[row[1]] = {row[2]: row[3]}
        # 保存到本地
        json.dump(train, open(self.trainPath, "w"))
        json.dump(test, open(self.testPath, "w"))
        self.connection.close()

    def load_data(self):
        if not (os.path.exists(self.trainPath) and os.path.exists(self.testPath)):
            self.save_data()
        self.train = json.load(open(self.trainPath))
        self.test = json.load(open(self.testPath))

    def recommend(self, uid, rankNum, recNum):
        uid = str(uid)
        distance_dict = {}
        for k in self.train.keys():
            if k != uid:
                distance = pearson(self.train[uid], self.train[k])
                distance_dict[k] = distance
        distance_sorted = sorted(
            distance_dict.items(), key=lambda x: x[1], reverse=True)
        commodity_dict = {}
        for (idCommodity, sim) in distance_sorted[:rankNum]:
            for cid in self.train[idCommodity]:
                commodity_dict.setdefault(cid, 0)
                commodity_dict[cid] += sim * self.train[idCommodity][cid]
        commodity_sorted = sorted(
            commodity_dict.items(), key=lambda x: x[1], reverse=True)
        return commodity_sorted[:recNum]
