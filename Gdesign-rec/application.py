import os
import sys
from importlib import reload

import tornado.web
from tornado.ioloop import IOLoop
from tornado.options import define, options, parse_command_line

from apps.handlers.health_checker import HealthChecker
from apps.handlers.rec_handler import RecHandler
from utils.consul_client import ConsulClient

reload(sys)


def main():
    # 读取项目配置
    from conf.config import getConfig
    conf = getConfig()
    c = ConsulClient(conf.consul_address, conf.consul_port)
    # 服务注册
    service_id = conf.application_name + ":" + conf.ip + ':' + str(conf.server_port)
    name = conf.application_name
    address = conf.ip
    port = conf.server_port
    tags = [conf.consul_tags]
    interval = 5
    httpcheck = conf.consul_healthCheckPath
    c.register(name, service_id, address, port, tags, interval, httpcheck)

    parse_command_line()
    app = tornado.web.Application(
        [
            (r"/actuator/health", HealthChecker),
            (r"/rec/contentBase", RecHandler)
        ]
    )
    http_server = tornado.httpserver.HTTPServer(app)
    http_server.listen(conf.server_port)
    tornado.ioloop.IOLoop.current().start()


if __name__ == "__main__":
    main()
