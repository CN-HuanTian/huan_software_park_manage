package org.huantian.huan_software_park_manage.controller;

import jakarta.validation.Valid;
import org.huantian.huan_software_park_manage.pojo.Result;
import org.huantian.huan_software_park_manage.pojo.dto.ApplicationCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ApplicationUpdateDTO;
import org.huantian.huan_software_park_manage.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;


    // @PostMapping("/add")
    // public Result add(@Valid @RequestBody ApplicationCreateDTO data) {
    //     return Result.success();
    // }

    @GetMapping("/del")
    public Result del(@RequestParam("id") Integer id) {
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody ApplicationUpdateDTO data) {
        return Result.success();
    }

    @GetMapping("/list")
    public Result list() {
        return Result.success();
    }

}
