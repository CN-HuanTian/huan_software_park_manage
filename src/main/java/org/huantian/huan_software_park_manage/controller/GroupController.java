package org.huantian.huan_software_park_manage.controller;

import jakarta.validation.Valid;
import org.huantian.huan_software_park_manage.pojo.PageBean;
import org.huantian.huan_software_park_manage.pojo.Result;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.GroupCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.GroupUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.GroupPO;
import org.huantian.huan_software_park_manage.pojo.vo.GroupMsgVO;
import org.huantian.huan_software_park_manage.pojo.vo.GroupVO;
import org.huantian.huan_software_park_manage.service.ClassifyService;
import org.huantian.huan_software_park_manage.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private ClassifyService classifyService;

    // 增
    @PostMapping("/add")
    public Result add(@Valid @RequestBody GroupCreateDTO data) {
        if (classifyService.findById(data.getClassifyId()) == null) {
            return Result.error(Result.Code.NOT_FOUND, "父分类不存在");
        }
        if (groupService.findByLabel(data.getLabel()) != null) {
            return Result.error(Result.Code.NOT_FOUND, "组名已存在");
        }
        groupService.add(data);
        return Result.success();
    }

    // 删
    @GetMapping("/del")
    public Result del(@RequestParam("id") Integer id) {
        if (groupService.findById(id) == null) {
            return Result.error(Result.Code.NOT_FOUND, "组不存在");
        }
        groupService.del(id);
        return Result.success();
    }

    // 改
    @PostMapping("/update")
    public Result update(@Valid @RequestBody GroupUpdateDTO data) {
        if (classifyService.findById(data.getClassifyId()) == null) {
            return Result.error(Result.Code.NOT_FOUND, "父分类不存在");
        }
        GroupPO gpo = groupService.findById(data.getId());
        if (gpo == null) {
            return Result.error(Result.Code.NOT_FOUND, "组不存在");
        }
        if ((groupService.findByLabel(data.getLabel()) != null) && !Objects.equals(gpo.getLabel(), data.getLabel())) {
            return Result.error(Result.Code.NOT_FOUND, "组名已存在");
        }
        groupService.update(data);
        return Result.success();
    }

    // 查
    @GetMapping("/list")
    public Result<PageBean<GroupVO>> list(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam(required = false) Status status, @RequestParam(required = false) List<Integer> classifyId, @RequestParam(required = false) String keyWord) {
        PageBean<GroupVO> list = groupService.list(page,pageSize,status,classifyId,keyWord);
        return Result.success(list);
    }

    // 省流查询
    @GetMapping("/msg")
    public Result msg() {
        List<GroupMsgVO> list = groupService.msg();
        return Result.success(list);
    }
}
