import tornado.web

import sys
import os
from apps.algorithms.contentBase.ContentBase import ContentBase

cb = ContentBase()


class RecHandler(tornado.web.RequestHandler):
    def get(self):
        res = cb.recommend(120405)
        print({"data": res})
        self.finish({"data": res})
