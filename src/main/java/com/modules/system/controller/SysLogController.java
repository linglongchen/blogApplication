package com.modules.system.controller;

import com.modules.common.generator.utils.Result;
import com.modules.common.utils.PageInfo;
import com.modules.system.entity.SysLog;
import com.modules.system.form.SysLogForm;
import com.modules.system.query.SysLogQuery;
import com.modules.system.service.SysLogService;
import com.modules.system.vo.SysLogVO;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author chen
* @date 2020-07-31 15:42:18
*/
@RestController
@RequestMapping("/sysLog")
@Api(value = "SysLogController", tags = {"SysLogController"}, description = "SysLogController")
public class SysLogController {
	@Resource
	private SysLogService sysLogService;


	@GetMapping("/get/{id}")
	@ApiImplicitParams({@ApiImplicitParam(name = "id",value = "id",defaultValue = "0")})
	@ApiOperation(value = "根据id获取数据")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = SysLogVO.class)
	})
	public Result get(@ApiParam(name = "id", value = "id", required = true) @PathVariable Long id) {
	 SysLog entity = sysLogService.get(id);
		if(entity == null){
			return Result.error("对象信息不存在！");
		}else{
			SysLogVO entityVO = new SysLogVO();
			BeanUtils.copyProperties(entity,entityVO);
			return Result.ok().data(entityVO);
		}

	}


	@DeleteMapping("/delete/{id}")
	@ApiImplicitParams({@ApiImplicitParam(name = "id",value = "id",defaultValue = "0")})
	@ApiOperation(value = "删除")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response =  Integer.class)
	})
	public Result delete(@ApiParam(name = "id", value = "id", required = true) @PathVariable Long id) {
		int i = sysLogService.delete(id);
		return Result.ok().data(i);
	}

	@PostMapping("/add")
	@ApiOperation(value = "添加")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = Integer.class)
	})
	public Result add(@ApiParam(name="用户对象",value="传入json格式",required=true)@RequestBody SysLogForm form) {
		SysLog entity = new SysLog();
		BeanUtils.copyProperties(form,entity);
		long i = sysLogService.insert(entity);
		return Result.ok().data(i);
	}

	@PutMapping("/update")
	@ApiOperation(value = "更新")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = Integer.class)
	})
	public Result update(@ApiParam(name="用户对象",value="传入json格式",required=true)@RequestBody SysLogForm form) {
		SysLog entity = new SysLog();
		BeanUtils.copyProperties(form,entity);
		int i = sysLogService.update(entity.getId(),entity);
		return Result.ok().data(i);
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取所有数据分页列表")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = SysLogVO.class, responseContainer = "List")
	})
	public Result page(@ApiParam(name="查询对象",value="传入json格式",required=true) SysLogQuery query, Integer page, Integer size) {
		page = page == null ? 1 : page;
		size = size == null ? 10 : size;
		PageInfo<SysLog> pageData = sysLogService.page(query,page,size);
		List<SysLog> list = pageData.getList();
			if(list == null){
			list = new ArrayList<>();
			}
		List<SysLogVO> voList = new ArrayList<SysLogVO>();
				for (SysLog entity : list) {
					SysLogVO entityVO = new SysLogVO();
					BeanUtils.copyProperties(entity,entityVO);
					voList.add(entityVO);
				}
		PageInfo<SysLogVO> pageInfo = new PageInfo<SysLogVO>(voList,pageData.getTotalCount(),pageData.getPageSize(),pageData.getCurrPage());
		return Result.ok().data(pageInfo);
	}

}
