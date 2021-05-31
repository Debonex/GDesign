# -*- coding: utf-8 -*-
import pymysql.cursors


class DataProcess:

    def __init__(self) -> None:
        self.connection = pymysql.connect(
            host='localhost', user='root', password='root', database='gdesign', charset='utf8mb4')


if __name__ == '__main__':
    control = DataProcess()
