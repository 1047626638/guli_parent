package com.guli.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.eduservice.entity.EduSubject;
import com.guli.eduservice.entity.excel.SubjectData;
import com.guli.eduservice.entity.subject.OneSubject;
import com.guli.eduservice.entity.subject.TwoSubject;
import com.guli.eduservice.listener.SubjectExcelListener;
import com.guli.eduservice.mapper.EduSubjectMapper;
import com.guli.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
            e.printStackTrace();
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //查询所有一级分类
        QueryWrapper<EduSubject> queryWrapperOne = new QueryWrapper<>();
        queryWrapperOne.eq("parent_id","0");
        List<EduSubject> oneSubjects = baseMapper.selectList(queryWrapperOne);
        //查询所有二级分类
        QueryWrapper<EduSubject> queryWrapperTwo = new QueryWrapper<>();
        queryWrapperTwo.ne("parent_id","0");
        List<EduSubject> twoSubjects = baseMapper.selectList(queryWrapperTwo);
        //创建list集合，用于存储最终封装数据
        List<OneSubject> finalSubjectList = new ArrayList<>();
        //封装一级分类
        //查询出来所有的一级分类list集合便利，得到每一个一级分类对象，获取每个一级分类对象值
        //封装到要求的list集合里面List<OneSubject> finalSubjectList
        for (EduSubject eduSubject:oneSubjects) {
            //得到oneSubjects每个eduSubject对象
            //把eduSubject里面值获取出来，放到OneSubject对象里面
            OneSubject oneSubject = new OneSubject();
           // oneSubject.setId(eduSubject.getId());
           // oneSubject.setTitle(eduSubject.getTitle());
            //eduSubject值复制到对应oneSubject对象里面
            BeanUtils.copyProperties(eduSubject,oneSubject);
            //多个OneSubject放到finalSubjectList里面
            finalSubjectList.add(oneSubject);
            //在一级分类循环遍历查询到所有的二级分类
            //创建list集合封装每个一级分类的二级分类
            List<TwoSubject> twoFinalSubject = new ArrayList<>();
            for (EduSubject tSubject:twoSubjects) {
                //判断二级分类的parentid和一级分类Id是否一样
                if(tSubject.getParentId().equals(eduSubject.getId())){
                    //把tSubject值复制到twoSubject里面，放到twoFinalSubject里面
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject,twoSubject);
                    twoFinalSubject.add(twoSubject);
                }
            }
            //把一级下面的二级分类放到一级里面
            oneSubject.setChildren(twoFinalSubject);
        }
        return finalSubjectList;
    }
}
