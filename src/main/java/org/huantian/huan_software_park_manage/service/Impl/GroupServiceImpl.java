package org.huantian.huan_software_park_manage.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.huantian.huan_software_park_manage.mapper.GroupMapper;
import org.huantian.huan_software_park_manage.pojo.PageBean;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.GroupCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.GroupUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.GroupPO;
import org.huantian.huan_software_park_manage.pojo.vo.GroupMsgVO;
import org.huantian.huan_software_park_manage.pojo.vo.GroupVO;
import org.huantian.huan_software_park_manage.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;

    // 根据组名查询组
    @Override
    public GroupPO findByLabel(String label) {
        return groupMapper.findByLabel(label);
    }

    // 根据id查询组
    @Override
    public GroupPO findById(Integer id) {
        return groupMapper.findById(id);
    }

    // 新增组
    @Override
    public void add(GroupCreateDTO data) {
        groupMapper.add(data);
    }

    // 删除组
    @Override
    public void del(Integer id) {
        groupMapper.del(id, Status.BAN);
    }

    // 修改组
    @Override
    public void update(GroupUpdateDTO data) {
        groupMapper.updata(data);
    }

    // 查询组
    @Override
    public PageBean<GroupVO> list(Integer pageNum, Integer pageSize, Status status, List<Integer> classifyId, String keyWord) {
        PageBean<GroupVO> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);

        List<GroupVO> list = groupMapper.list(status, keyWord, classifyId);
        Page<GroupVO> page = (Page<GroupVO>) list;
        pageBean.setCounts(page.getTotal());
        pageBean.setPage(page.getPageNum());
        pageBean.setPages(page.getPages());
        pageBean.setPageSize(page.getPageSize());
        pageBean.setItems(page.getResult());
        return pageBean;
    }

    // 省流查询
    @Override
    public List<GroupMsgVO> msg() {
        return groupMapper.msg();
    }
}
