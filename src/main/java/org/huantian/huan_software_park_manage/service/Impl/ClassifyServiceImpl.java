package org.huantian.huan_software_park_manage.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.huantian.huan_software_park_manage.mapper.ClassifyMapper;
import org.huantian.huan_software_park_manage.pojo.PageBean;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.ClassifyCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ClassifyUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.ClassifyPO;
import org.huantian.huan_software_park_manage.pojo.vo.ClassifyMsgVO;
import org.huantian.huan_software_park_manage.pojo.vo.ClassifyVO;
import org.huantian.huan_software_park_manage.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;

    // 根据分类名查询分类
    @Override
    public ClassifyPO findByLabel(String label) {
        return classifyMapper.findByLabel(label);
    }

    // 根据id查询分类
    @Override
    public ClassifyPO findById(Integer id) {
        return classifyMapper.findById(id);
    }

    // 新增分类
    @Override
    public void add(ClassifyCreateDTO data) {
        classifyMapper.add(data);
    }

    // 删除分类
    @Override
    public void del(Integer id) {
        classifyMapper.del(id, Status.BAN);
    }

    // 修改分类
    @Override
    public void update(ClassifyUpdateDTO data) {
        classifyMapper.update(data);
    }

    @Override
    public PageBean<ClassifyVO> list(Integer pageNum, Integer pageSize, Status status, String keyWord) {
        PageBean<ClassifyVO> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);

        List<ClassifyVO> list = classifyMapper.list(status,keyWord);

        Page<ClassifyVO> page =(Page<ClassifyVO>) list;
        pageBean.setCounts(page.getTotal());
        pageBean.setPage(page.getPageNum());
        pageBean.setPages(page.getPages());
        pageBean.setPageSize(page.getPageSize());
        pageBean.setItems(page.getResult());
        return pageBean;
    }
    // 省流查询
    @Override
    public List<ClassifyMsgVO> msg() {
        return classifyMapper.msg();
    }
}
