package com.guli.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.eduservice.entity.EduSubject;
import com.guli.eduservice.entity.excel.SubjectData;
import com.guli.eduservice.service.EduSubjectService;
import com.guli.servicebase.config.exceptionhandler.GuliException;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    //因为SubjectExcelListener不能叫给spring进行管理，需要自己new，不能注入其他对象
    //不能实现数据库操作
    public EduSubjectService eduSubjectService;
    public SubjectExcelListener() {
    }
    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    //读取excel内容，一行一行进行读取
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if(subjectData == null){
            throw new GuliException(20001,"文件数据为空！");
        }
        //一行一行读取，每次读取有两个值，第一个值一级分类，第二个值二级分类
        //判断一级分类是否重复
        EduSubject existOneSubject = this.existOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        if(existOneSubject == null){//没有相同一级分类，进行添加
            existOneSubject = new EduSubject();
            existOneSubject.setTitle(subjectData.getOneSubjectName());//一级分类名称
            existOneSubject.setParentId("0");
            eduSubjectService.save(existOneSubject);
       }
        //判断二级分类是否重复
        EduSubject existTwoSubject = this.existTwoSubject(eduSubjectService,subjectData.getOneSubjectName(),subjectData.getTwoSubjectName());
        if(existTwoSubject == null){
            existTwoSubject = new EduSubject();
            existTwoSubject.setTitle(subjectData.getTwoSubjectName());
            existTwoSubject.setParentId(existOneSubject.getId());
            eduSubjectService.save(existTwoSubject);
        }
    }
    //判断一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService eduSubjectService,String name){
        QueryWrapper queryWrapper = new QueryWrapper<EduSubject>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id","0");
        EduSubject oneSubject = eduSubjectService.getOne(queryWrapper);
        return oneSubject;
    }

    //判断二级分类不能重复添加
    private EduSubject existTwoSubject(EduSubjectService eduSubjectService,String name,String pid){
        QueryWrapper queryWrapper = new QueryWrapper<EduSubject>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id",pid);
        EduSubject twoSubject = eduSubjectService.getOne(queryWrapper);
        return twoSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
