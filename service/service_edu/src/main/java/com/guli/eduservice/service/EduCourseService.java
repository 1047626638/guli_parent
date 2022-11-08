package com.guli.eduservice.service;

import com.guli.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author lipeng
 * @since 2022-11-07
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);
}
