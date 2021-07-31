import json
from abc import ABC
import requests

import tornado.web
from apps.algorithms.contentBase.ContentBase import ContentBase
from utils.consul_client import ConsulClient
from conf.config import getConfig

cb = ContentBase()
conf = getConfig()
consul = ConsulClient(conf.consul_address, conf.consul_port)

businessService = consul.getService('business-service')


class RecHandler(tornado.web.RequestHandler, ABC):
    def get(self):
        res = cb.recommend(120405)
        idList = []
        for item in res:
            idList.append(item[0])
        url = 'http://' + businessService[0] + ':' + str(businessService[1]) + "/commodity/selectCommodityList"
        commodityList = requests.post(url, json=idList)
        self.finish(json.loads(commodityList.text))
