package com.guli.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.guli.eduservice.entity.EduSubject;
import com.guli.eduservice.entity.excel.SubjectData;
import com.guli.eduservice.listener.SubjectExcelListener;
import com.guli.eduservice.mapper.EduSubjectMapper;
import com.guli.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author lipeng
 * @since 2022-11-06
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    //添加课程分类
    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {
            //文件输入流
            InputStream in = file.getInputStream();
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        }catch (Exception e){

        }


    }
}
