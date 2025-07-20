package org.huantian.huan_software_park_manage.controller;

import jakarta.validation.Valid;
import org.huantian.huan_software_park_manage.pojo.Result;
import org.huantian.huan_software_park_manage.pojo.dto.ListCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ListUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.ListPO;
import org.huantian.huan_software_park_manage.pojo.vo.ListMsgVO;
import org.huantian.huan_software_park_manage.service.ClassifyService;
import org.huantian.huan_software_park_manage.service.GroupService;
import org.huantian.huan_software_park_manage.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/list")
public class ListController {
    @Autowired
    private ListService listService;
    @Autowired
    private GroupService groupService;
    // 增
    @PostMapping("/add")
    public Result add(@Valid @RequestBody ListCreateDTO data){

        System.out.println("master");
        System.out.println("master");
        System.out.println("master");

        if (groupService.findById(data.getGroupId()) == null) {
            return Result.error(Result.Code.NOT_FOUND, "父分组不存在");
        }
        if (listService.findByLabel(data.getLabel()) != null) {
            return Result.error(Result.Code.NOT_FOUND, "列表名已存在");
        }
        listService.add(data);
        return Result.success();
    }
    // 删
    @GetMapping("/del")
    public Result del(@RequestParam("id") Integer id){
        if (listService.findById(id) == null) {
            return Result.error(Result.Code.NOT_FOUND, "列表不存在");
        }
        listService.del(id);
        return Result.success();
    }
    // 改
    @PostMapping("/update")
    public Result update(@Valid @RequestBody ListUpdateDTO data){
        if (groupService.findById(data.getGroupId()) == null) {
            return Result.error(Result.Code.NOT_FOUND, "父分组不存在");

        }
        ListPO lo = listService.findById(data.getId());
        if (lo == null) {
            return Result.error(Result.Code.NOT_FOUND, "列表不存在");
        }
        if ((listService.findByLabel(data.getLabel()) != null) && !Objects.equals(lo.getLabel(), data.getLabel())) {
            return Result.error(Result.Code.NOT_FOUND, "列表名已存在");
        }
        listService.update(data);
        return Result.success();
    }
    // 省流查询

    // 省流查询
    @GetMapping("/msg")
    public Result msg() {
        List<ListMsgVO> list = listService.msg();
        return Result.success(list);
    }
}
