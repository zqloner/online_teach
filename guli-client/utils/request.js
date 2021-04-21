import axios from 'axios'
// 创建axios实例
const service = axios.create({
  //baseURL: 'http://localhost:8201', // api的base_url
  baseURL: 'http://192.168.29.102:81', // nginx地址。
  timeout: 20000 // 请求超时时间
})
export default service
