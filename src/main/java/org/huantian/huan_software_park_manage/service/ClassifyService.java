package org.huantian.huan_software_park_manage.service;

import org.huantian.huan_software_park_manage.pojo.PageBean;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.ClassifyCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ClassifyUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.ClassifyPO;
import org.huantian.huan_software_park_manage.pojo.vo.ClassifyMsgVO;
import org.huantian.huan_software_park_manage.pojo.vo.ClassifyVO;

import java.util.List;

public interface ClassifyService {
    // 根据分类名查询分类
    ClassifyPO findByLabel(String label);
    // 根据id查询分类
    ClassifyPO findById(Integer id);
    // 新增分类
    void add(ClassifyCreateDTO data);
    // 删除分类
    void del(Integer id);
    // 修改分类
    void update(ClassifyUpdateDTO data);
    // 查询分类
    PageBean<ClassifyVO> list(Integer pageNum, Integer pageSize, Status status, String keyWord);
    // 省流查询
    List<ClassifyMsgVO> msg();
}
