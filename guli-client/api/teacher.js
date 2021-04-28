import request from '@/utils/request'
const api_name = '/serviceedu/teacherfront'
export default {
  getPageList(page, limit) {
    return request({
      url: `${api_name}/getTeacherFrontList/${page}/${limit}`,
      method: 'get'
    })
  }
}
