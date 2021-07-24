import request from "./request";

export default {
  register: params => {
    return request.post("/user/register", params);
  }
};
