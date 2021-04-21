import request from '@/utils/request'
export default {
  getList() {
    return request({
      url: `/serviceedu/client/index`,
      method: 'get'
    })
  }
}
