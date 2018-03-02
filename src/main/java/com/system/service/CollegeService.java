package com.system.service;

import com.system.po.College;

import java.util.List;

public interface CollegeService {

    List<College> findAll() throws Exception;
}
