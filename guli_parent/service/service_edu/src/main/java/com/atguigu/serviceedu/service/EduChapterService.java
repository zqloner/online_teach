package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.vo.chapter.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zhangqi
 * @since 2021-04-15
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> nestedList(String courseId);

    boolean removeChapterById(String id);

    boolean removeByCourseId(String id);
}
