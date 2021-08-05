# -*- coding: utf-8 -*-

from utils.pytools import Pytools
import sys
import pymysql.cursors
sys.path.append('..')


class DataImport:

    def __init__(self, host, user, password, database, charset='utf8mb4'):
        self.connection = pymysql.connect(
            host=host, user=user, password=password, database=database, charset=charset)
        self.pt = Pytools()
        self.dict_commodity_title_id = {}

    def importSql(self, path):
        with self.connection.cursor() as cursor:
            fd = open(path, 'r')
            sqlFile = fd.read()
            fd.close()
            sqlCommands = sqlFile.split(';')
            for command in sqlCommands:
                if command.strip() != '':
                    cursor.execute(command)

    def __solve_commodities(self, path):
        commodities = []
        num = 0
        with open(path, 'r', encoding='utf-8') as file:
            line = file.readline()
            while True:
                line = file.readline().strip()
                num += 1
                if(len(line) == 0):
                    break
                commodity = line.split(',')
                commodities.append(
                    {"id": num, "title": commodity[0].strip(), "entity": commodity[1],
                     "hire": commodity[2], "timelimit": commodity[3], "region": commodity[4]})
                self.dict_commodity_title_id[commodity[0].strip()] = num
        return commodities

    def __update_commodities(self, path):
        commodities = []
        with open(path, 'r', encoding='utf-8') as file:
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
                    "value": self.pt.convert_str_to_float(commodity[2])
                })
        cursor = self.connection.cursor()
        cursor.execute('select title from commodity;')
        titles = list(cursor.fetchall())
        titles = list(map(lambda x: x[0], titles))
        for com in commodities:
            if com["title"] in titles:
                sql = """update commodity set specification = '%s',value = '%f' where title = '%s'""" %\
                    (com["specification"], com["value"], com["title"])
                self.connection.cursor().execute(sql)
        with self.connection.cursor() as cursor:
            sql = "update commodity set value = '9.9',specification = '无' where value is null or specification is null"
            cursor.execute(sql)
        self.connection.commit()
        print("updating commodity finished.......")

    def __solve_orders(self, path):
        orders = []
        # quantity of orders
        num = 0
        with open(path, 'r', encoding='utf-8') as file:
            line = file.readline()
            while True:
                line = file.readline().strip()
                num += 1
                if(len(line) == 0):
                    break
                order = line.split(',')
                id_order = order[2]
                title_commodity = order[0].strip()
                num_commodity = int(float(order[3]))
                amount_order = float(order[4])
                commision1 = float(order[6])
                commision2 = float(order[8])
                commision3 = float(order[10])
                id_distributor1 = self.pt.conver_str_to_int(order[7])
                id_distributor2 = self.pt.conver_str_to_int(order[9])
                id_distributor3 = self.pt.conver_str_to_int(order[11])
                uid = int(float(order[18]))
                id_commodity = self.dict_commodity_title_id[title_commodity]
                orders.append({'id_order': id_order,
                               'id_commodity': id_commodity,
                               'num_commodity': num_commodity,
                               'amount_order': amount_order,
                               'commission1': commision1,
                               'id_distributor1': id_distributor1,
                               'commission2': commision2,
                               'id_distributor2': id_distributor2,
                               'commission3': commision3,
                               'id_distributor3': id_distributor3,
                               'uid': uid})
        return orders

    def __import_orders_single(self, path):
        orders = self.__solve_orders(path)
        with self.connection.cursor() as cursor:
            cursor.execute("SET FOREIGN_KEY_CHECKS = 0;")
            for item in orders:
                sql = """INSERT INTO ORDERS(id_order,id_commodity,num_commodity,amount_order,commission1,id_distributor1,commission2,id_distributor2,commission3,id_distributor3,uid)
                VALUES('%s','%d','%d','%f','%f','%d','%f','%d','%f','%d','%d')""" % (item['id_order'], item["id_commodity"], item["num_commodity"], item["amount_order"], item["commission1"], item["id_distributor1"], item["commission2"], item["id_distributor2"], item["commission3"], item["id_distributor3"], item["uid"])
                cursor.execute(sql)
            cursor.execute("SET FOREIGN_KEY_CHECKS = 1;")
        self.connection.commit()
        print('importing %s finished. %d items in total......' %
              (path, len(orders)))

    def import_commodities(self, path, path_value):
        print('starting import commodities......')
        commodities = self.__solve_commodities(path)

        with self.connection.cursor() as cursor:
            for item in commodities:
                sql = """INSERT INTO COMMODITY(id_commodity,TITLE,ENTITY,HIRE,TIMELIMIT,REGION)
                VALUES('%d','%s','%s','%s','%s','%s')""" % (item['id'], item["title"], item["entity"], item["hire"], item["timelimit"], item["region"])
                cursor.execute(sql)
            self.connection.commit()
            print("inserting commodity finished. %d kinds of commodities in total......" % len(
                commodities))
        self.__update_commodities(path_value)

    def import_orders(self, path):
        print('starting import orders......')
        if self.dict_commodity_title_id == {}:
            self.__solve_commodities()
        list_order_csv = self.pt.get_file_list(path)
        for csv in list_order_csv:
            self.__import_orders_single(csv)
        print('importing orders finished......')
