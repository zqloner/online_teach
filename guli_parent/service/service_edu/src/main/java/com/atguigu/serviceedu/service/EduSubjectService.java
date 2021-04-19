package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduSubject;
import com.atguigu.serviceedu.entity.vo.SubjectNestedVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author zhangqi
 * @since 2021-04-14
 */
public interface EduSubjectService extends IService<EduSubject> {

    void importSubjectData(MultipartFile file, EduSubjectService subjectService);

    List<SubjectNestedVo> nestedList();
}
