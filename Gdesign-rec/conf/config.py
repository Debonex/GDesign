import os
import socket
import sys


# import manage

class Config(object):  # 默认配置
    DEBUG = False
    hostname = socket.gethostname()
    ip = socket.gethostbyname(hostname)

    application_name = "rec-service"
    application_version = "1.0"
    server_port = 8083

    # mysql
    mysql = {
        "host": "localhost",
        "user": "root",
        "password": "root",
        "database": "gdesign",
        "charset": "utf8mb4"
    }

    # get attribute
    def __getitem__(self, key):
        return self.__getattribute__(key)


class DevelopmentConfig(Config):  # 开发环境
    consul_address = "127.0.0.1"
    consul_port = "8500"
    consul_healthCheckPath = "http://127.0.0.1:8083/actuator/health"
    consul_tags = "dev"


class ProductionConfig(Config):  # 生产环境
    consul_address = "127.0.0.1"
    consul_port = "8500"
    consul_healthCheckPath = "http://127.0.0.1:8083/actuator/health"
    consul_tags = "prod"


# 环境映射关系
mapping = {
    'dev': DevelopmentConfig,
    'pro': ProductionConfig,
    'default': DevelopmentConfig
}


# 根据脚本参数，来决定用那个环境配置


def getConfig():
    num = len(sys.argv) - 1  # 参数个数
    if num < 1 or num > 1:
        exit("参数错误,必须传环境变量!比如: python xx.py dev|pro|default")
    env = "dev"  # sys.argv[1]  # 环境
    APP_ENV = os.environ.get('APP_ENV', env).lower()
    return mapping[APP_ENV]()  # 实例化对应的环境
