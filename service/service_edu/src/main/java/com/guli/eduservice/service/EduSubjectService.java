package com.guli.eduservice.service;

import com.guli.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author lipeng
 * @since 2022-11-06
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    List<OneSubject> getAllOneTwoSubject();
}
