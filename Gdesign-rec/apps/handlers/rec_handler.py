import json
from abc import ABC
import requests

import tornado.web
from apps.algorithms.contentbase.content_base import ContentBase
from utils.consul_client import ConsulClient
from conf.config import getConfig

conf = getConfig()
consul = ConsulClient(conf.consul_address, conf.consul_port)
cb = ContentBase(trainPath="apps/datasets/contentbase/train.json", testPath="apps/datasets/contentbase/test.json")


class RecHandler(tornado.web.RequestHandler, ABC):
    def get(self):
        businessService = consul.getService('business-service')
        res = cb.recommend(self.get_argument('uid'), rankNum=10, recNum=16)
        idList = []
        for item in res:
            idList.append(item[0])
        url = 'http://' + businessService[0] + ':' + str(businessService[1]) + "/commodity/selectCommodityList"
        commodityList = requests.post(url, json=idList)
        self.finish(json.loads(commodityList.text))
