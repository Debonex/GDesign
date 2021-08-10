import request from "./request";

export default {
  rec: {
    recommend: params => {
      return request.get("/rec/recommend", params);
    }
  }
};
