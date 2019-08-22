package com.baiteng.service.impl;

import com.baiteng.dao.FamilyNumberMapper;
import com.baiteng.service.FamilyNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyNumberServiceImpl implements FamilyNumberService {
    @Autowired
    FamilyNumberMapper familyNumberMapper;
}
