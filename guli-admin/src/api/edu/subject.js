import request from '@/utils/request'
export default {

  getNestedTreeList() {
    return request({
      url: `/serviceedu/edu-subject/getSubjects`,
      method: 'get'
    })
  }
}
