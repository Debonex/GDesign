import requests
import json

URL = 'http://127.0.0.1:8084'


def getCommodity(commodityId):
    params = {
        "commodityId": commodityId
    }
    return requests.get(URL + '/commodity/findById', params=params)


def getCommodityList(commodityIdList):
    data = {
        "commodityIdList": list(map(lambda x: int(x), commodityIdList))
    }
    return requests.post(URL + '/commodity/findListById', json=json.dumps(data))
