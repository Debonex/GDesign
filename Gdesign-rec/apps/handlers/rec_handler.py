from abc import ABC

import tornado.web

from apps.algorithms.contentBase.ContentBase import ContentBase
import apps.requests.data_requests as dr

cb = ContentBase()


class RecHandler(tornado.web.RequestHandler, ABC):
    def get(self):
        res = cb.recommend(120405)
        print({"data": res})
        response = dr.getCommodity(20)
        self.finish({"data": res, "response": response.content.decode()})
