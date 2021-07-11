import tornado.web

import sys
import os
sys.path.append('..')
from algorithms.contentBase.ContentBase import ContentBase

cb = ContentBase()

class RecHandler(tornado.web.RequestHandler):
    def get(self):
        res = cb.recommend(120405)
        self.finish(res)
