import request from "./request";

export default {
  selectPage: params => {
    return request.get("/commodity/selectCommodityPage", params);
  }
};
