package com.guli.eduservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author lipeng
 * @since 2022-08-29
 */
public interface EduTeacherService extends IService<EduTeacher> {
    //分页条件查询
     void pageQuery(Page<EduTeacher> teacherPage, TeacherQuery teacherQuery);

}
