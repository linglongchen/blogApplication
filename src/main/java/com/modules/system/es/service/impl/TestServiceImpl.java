package com.modules.system.es.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.system.es.bean.TestBean;
import com.modules.system.es.dao.TestDAO;
import com.modules.system.es.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
/**
 * @author v_vllchen
 */
@Service
public class TestServiceImpl implements TestService {


    @Resource
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Resource
    private TestDAO elasticRepository;




    @Override
    public void createIndex() {
        elasticsearchTemplate.createIndex(TestBean.class);
    }

    @Override
    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }

    @Override
    public void save(TestBean docBean) {
        elasticRepository.save(docBean);
    }

    @Override
    public void saveAll(List<TestBean> list) {
        elasticRepository.saveAll(list);
    }

    @Override
    public Iterator<TestBean> findAll() {
        return elasticRepository.findAll().iterator();
    }

    @Override
    public Page<TestBean> findByContent(String content) {
        return elasticRepository.findByContent(content);
    }

    @Override
    public Page<TestBean> findByFirstCode(String firstCode) {
        return elasticRepository.findByFirstCode(firstCode);
    }

    @Override
    public Page<TestBean> findBySecordCode(String secordCode) {
        return elasticRepository.findBySecordCode(secordCode);
    }

    @Override
    public Page<TestBean> query(String key) {
        return elasticRepository.findByContent(key);
    }
}
