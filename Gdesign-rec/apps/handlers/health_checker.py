from abc import ABC

import tornado.web


class HealthChecker(tornado.web.RequestHandler, ABC):
    def get(self, *args, **kwargs):
        self.write("ok")
