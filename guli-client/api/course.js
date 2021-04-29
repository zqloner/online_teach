import request from '@/utils/request'
export default {
  getPageList(page, limit, searchObj) {
    return request({
      url: `/serviceedu/coursefront/getFrontCourseList/${page}/${limit}`,
      method: 'post',
      data: searchObj
    })
  },
  // 获取课程二级分类
  getAllSubjects() {
    return request({
      url: `/serviceedu/edu-subject/getSubjects`,
      method: 'get'
    })
  },
  getById(courseId) {
    return request({
      url: `/serviceedu/edu-course/${courseId}`,
      method: 'get'
    })
  }
}
