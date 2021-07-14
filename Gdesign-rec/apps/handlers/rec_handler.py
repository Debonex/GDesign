import json
from abc import ABC

import tornado.web

from apps.algorithms.contentBase.ContentBase import ContentBase
import apps.requests.data_requests as dr

cb = ContentBase()


class RecHandler(tornado.web.RequestHandler, ABC):
    def get(self):
        res = cb.recommend(120405)
        idList = []
        for item in res:
            idList.append(item[0])
        commodityList = dr.getCommodityList(idList)
        self.finish({"data": json.loads(commodityList.text)})
