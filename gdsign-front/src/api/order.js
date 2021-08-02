import request from "./request";

export default {
  selectOrderPage: params => {
    return request.get("/order/selectOrderPage", params);
  },
  insertOrder: params => {
    return request.get("/order/insertOrder", params);
  },
  deleteOrder: params => {
    return request.get("/order/deleteOrder", params);
  },
  updateOrder: params => {
    return request.get("/order/updateOrder", params);
  }
};
