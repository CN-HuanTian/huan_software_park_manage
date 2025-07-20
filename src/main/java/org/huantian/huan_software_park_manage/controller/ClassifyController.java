package org.huantian.huan_software_park_manage.controller;

import jakarta.validation.Valid;
import org.huantian.huan_software_park_manage.pojo.PageBean;
import org.huantian.huan_software_park_manage.pojo.Result;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.ClassifyCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ClassifyUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.ClassifyPO;
import org.huantian.huan_software_park_manage.pojo.vo.ClassifyMsgVO;
import org.huantian.huan_software_park_manage.pojo.vo.ClassifyVO;
import org.huantian.huan_software_park_manage.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;
    // 增
    @PostMapping("/add")
    public Result add(@Valid @RequestBody ClassifyCreateDTO data) {
        if (!(classifyService.findByLabel(data.getLabel()) == null)) {
            return Result.error(Result.Code.NOT_FOUND, "分类名已存在");
        }
        classifyService.add(data);
        return Result.success();
    }
    // 删
    @GetMapping("/del")
    public Result del(@RequestParam("id") Integer id) {
        if (classifyService.findById(id) == null) {
            return Result.error(Result.Code.NOT_FOUND, "分类不存在");
        }
        classifyService.del(id);
        return Result.success();
    }
    // 改
    @PostMapping("/update")
    public Result update(@Valid @RequestBody ClassifyUpdateDTO data) {
        ClassifyPO po = classifyService.findById(data.getId());
        if (po == null) {
            return Result.error(Result.Code.NOT_FOUND, "分类不存在");
        }
        if ((classifyService.findByLabel(data.getLabel()) != null) && !Objects.equals(po.getLabel(), data.getLabel())) {
            return Result.error(Result.Code.NOT_FOUND, "分类名已存在");
        }
        classifyService.update(data);
        return Result.success();
    }
    // 查
    @GetMapping("/list")
    public Result<PageBean<ClassifyVO>> list(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam(required = false) Status status, @RequestParam(required = false) String keyWord) {
        PageBean<ClassifyVO> list = classifyService.list(page,pageSize,status,keyWord);
        return Result.success(list);
    }

    // 省流查询
    @GetMapping("/msg")
    public Result msg() {
        List<ClassifyMsgVO> list = classifyService.msg();
        return Result.success(list);
    }
}
