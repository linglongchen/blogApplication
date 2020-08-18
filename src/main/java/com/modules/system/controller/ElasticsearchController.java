package com.modules.system.controller;

import com.modules.common.annotation.IgnoreSecurity;
import com.modules.common.generator.utils.Result;
import com.modules.system.es.bean.TestBean;
import com.modules.system.es.service.TestService;
import com.modules.system.vo.SysMenuVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author v_vllchen
 */
@RestController
@RequestMapping("/elastic")
@Api(value = "ElasticsearchController", tags = {"ElasticsearchController"}, description = "elasticsearch测试类")
public class ElasticsearchController {
    @Autowired
    private TestService elasticService;

    @GetMapping("/init")
    @ApiOperation(value = "根据id获取数据")
    @ApiResponses({
            @ApiResponse(code = 200, message = "返回数据", response = SysMenuVO.class)
    })
    public com.modules.common.generator.utils.Result init(){
        elasticService.createIndex();
        List<TestBean> list =new ArrayList<>();
        list.add(new TestBean(1L,"XX0193","XX8064","xxxxxx",1));
        list.add(new TestBean(2L,"XX0210","XX7475","xxxxxxxxxx",1));
        list.add(new TestBean(3L,"XX0257","XX8097","xxxxxxxxxxxxxxxxxx",1));
        elasticService.saveAll(list);
        return Result.ok();
    }

    @GetMapping("/all")
    @ApiOperation(value = "根据id获取数据")
    @ApiResponses({
            @ApiResponse(code = 200, message = "返回数据", response = SysMenuVO.class)
    })
    public com.modules.common.generator.utils.Result all(){
        return Result.ok().data(elasticService.findAll());
    }
}
