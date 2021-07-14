import requests

URL = 'http://127.0.0.1:8084'


def getCommodity(commodityId):
    params = {
        "commodityId": commodityId
    }
    return requests.get(URL + '/commodity/findById', params=params)
