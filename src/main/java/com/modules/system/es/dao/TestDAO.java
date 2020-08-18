package com.modules.system.es.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.system.es.bean.TestBean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author v_vllchen
 */
@Repository
public interface TestDAO extends ElasticsearchRepository<TestBean, Long> {



    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
    Page<TestBean> findByContent(String content);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"firstCode.keyword\" : \"?\"}}}}")
    Page<TestBean> findByFirstCode(String firstCode);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"secordCode.keyword\" : \"?\"}}}}")
    Page<TestBean> findBySecordCode(String secordCode);

}
