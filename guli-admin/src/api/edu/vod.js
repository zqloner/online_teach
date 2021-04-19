import request from '@/utils/request'

const api_name = '/servicevod/video'

export default {

  removeById(id) {
    return request({
      url: `${api_name}/${id}`,
      method: 'delete'
    })
  }
}
