import axios from 'axios'

const instance = axios.create({
  // use proxy to crossregion
  baseURL: '/api',
  timeout: 10000
})

const request = {
  get: (url, data = {}, config = {}) => {
      return instance.get(url, {...{params: data}, ...config})
  },
  post: (url, data = {}, config = {}) => {
      return instance.post(url, data, config)
  }
}

export default request
