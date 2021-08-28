import request from "./request";

export default {
  selectPage: params => {
    return request.get("/commodity/selectCommodityPage", params);
  },
  addCommodity: params => {
    return request.post("/commodity/insertCommodity", params);
  },
  searchCommodityList: params => {
    return request.get("/commodity/searchCommodityList", params);
  }
};
