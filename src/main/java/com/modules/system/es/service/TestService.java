package com.modules.system.es.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.system.es.bean.TestBean;

import java.util.Iterator;
import java.util.List;

public interface TestService {
    void createIndex();

    void deleteIndex(String index);

    void save(TestBean docBean);

    void saveAll(List<TestBean> list);

    Iterator<TestBean> findAll();

    Page<TestBean> findByContent(String content);

    Page<TestBean> findByFirstCode(String firstCode);

    Page<TestBean> findBySecordCode(String secordCode);

    Page<TestBean> query(String key);
}
