import request from "./request";

export default {
  selectOrderPage: params => {
    return request.get("/order/selectOrderPage", params);
  }
};
