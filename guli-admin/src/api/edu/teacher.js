import request from '@/utils/request'

export default {
  getTeacherListPage(page, limit, teacherQuery) {
    return request({
      url: `/serviceedu/edu-teacher/pageTeacherCondition/${page}/${limit}`,
      method: 'post',
      //teacherQuery条件对象。后端使用RequestBody获取数据
      //data表示把对象转换json进行传递到接口里面
      data: teacherQuery
    })
  },
  removeById(teacherId) {
    return request({
      url: `/serviceedu/edu-teacher/deleteTeacher/${teacherId}`,
      method: 'delete'
    })
  },
  save(teacher) {
    return request({
      url: `/serviceedu/edu-teacher/addTeacher`,
      method: 'post',
      data: teacher
    })
  },
  getById(id) {
    return request({
      url: `/serviceedu/edu-teacher/getTeacher/${id}`,
      method: 'get'
    })
  },
  updateById(teacher) {
    return request({
      url: `/serviceedu/edu-teacher/updateTeacher/${teacher.id}`,
      method: 'put',
      data: teacher
    })
  },
  getList() {
    return request({
      url: '/serviceedu/edu-teacher/findAll',
      method: 'get'
    })
  },
}
