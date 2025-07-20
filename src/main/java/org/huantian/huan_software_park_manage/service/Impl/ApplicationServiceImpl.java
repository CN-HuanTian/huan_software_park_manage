package org.huantian.huan_software_park_manage.service.Impl;

import org.huantian.huan_software_park_manage.mapper.ApplicationMapper;
import org.huantian.huan_software_park_manage.pojo.po.ApplicationPO;
import org.huantian.huan_software_park_manage.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public ApplicationPO findById(Integer id) {
        return applicationMapper.findById(id);
    }

    @Override
    public ApplicationPO findByLabel(String label) {
        return applicationMapper.findByLabel(label);
    }
}
