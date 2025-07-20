package org.huantian.huan_software_park_manage.service.Impl;

import org.huantian.huan_software_park_manage.mapper.ListMapper;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.ListCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ListUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.ListPO;
import org.huantian.huan_software_park_manage.pojo.vo.ListMsgVO;
import org.huantian.huan_software_park_manage.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {
    @Autowired
    private ListMapper listMapper;
    // 根据id查询
    @Override
    public ListPO findById(int id) {
        return listMapper.findById(id);
    }
    // 根据列表名查询
    @Override
    public ListPO findByLabel(String label) {
        return listMapper.findByLabel(label);
    }
    // 增
    @Override
    public void add(ListCreateDTO data) {
        listMapper.add(data);
    }
    // 删
    @Override
    public void del(Integer id) {
        listMapper.del(id, Status.BAN);
    }
    // 改
    @Override
    public void update(ListUpdateDTO data) {
        listMapper.update(data);
    }
    // 省流查询
    @Override
    public List<ListMsgVO> msg() {
        return listMapper.msg();
    }
}
