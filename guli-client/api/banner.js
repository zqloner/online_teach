import request from '@/utils/request'
export default {
  getList() {
    return request({
      url: `/servicecms/client-banner/getAllBanner`,
      method: 'get'
    })
  }
}
