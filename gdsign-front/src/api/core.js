import request from "./request";

export default {
  rec: {
    contentBase: params => {
      return request.get("/rec/contentBase", params);
    }
  }
};
