package com.modules.system.controller;

import com.modules.common.generator.utils.Result;
import com.modules.common.utils.PageInfo;
import com.modules.system.entity.SysRole;
import com.modules.system.form.SysRoleForm;
import com.modules.system.query.SysRoleQuery;
import com.modules.system.service.SysRoleService;
import com.modules.system.vo.SysRoleVO;
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
@RequestMapping("/sysRole")
@Api(value = "SysRoleController", tags = {"SysRoleController"}, description = "SysRoleController")
public class SysRoleController {
	@Resource
	private SysRoleService sysRoleService;


	@GetMapping("/get/{id}")
	@ApiImplicitParams({@ApiImplicitParam(name = "id",value = "id",defaultValue = "0")})
	@ApiOperation(value = "根据id获取数据")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = SysRoleVO.class)
	})
	public Result get(@ApiParam(name = "id", value = "id", required = true) @PathVariable Long id) {
	 SysRole entity = sysRoleService.get(id);
		if(entity == null){
			return Result.error("对象信息不存在！");
		}else{
			SysRoleVO entityVO = new SysRoleVO();
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
		int i = sysRoleService.delete(id);
		return Result.ok().data(i);
	}

	@PostMapping("/add")
	@ApiOperation(value = "添加")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = Integer.class)
	})
	public Result add(@ApiParam(name="用户对象",value="传入json格式",required=true)@RequestBody SysRoleForm form) {
		SysRole entity = new SysRole();
		BeanUtils.copyProperties(form,entity);
		long i = sysRoleService.insert(entity);
		return Result.ok().data(i);
	}

	@PutMapping("/update")
	@ApiOperation(value = "更新")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = Integer.class)
	})
	public Result update(@ApiParam(name="用户对象",value="传入json格式",required=true)@RequestBody SysRoleForm form) {
		SysRole entity = new SysRole();
		BeanUtils.copyProperties(form,entity);
		int i = sysRoleService.update(entity.getId(),entity);
		return Result.ok().data(i);
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取所有数据分页列表")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = SysRoleVO.class, responseContainer = "List")
	})
	public Result page(@ApiParam(name="查询对象",value="传入json格式",required=true) SysRoleQuery query, Integer page, Integer size) {
		page = page == null ? 1 : page;
		size = size == null ? 10 : size;
		PageInfo<SysRole> pageData = sysRoleService.page(query,page,size);
		List<SysRole> list = pageData.getList();
			if(list == null){
			list = new ArrayList<>();
			}
		List<SysRoleVO> voList = new ArrayList<SysRoleVO>();
				for (SysRole entity : list) {
					SysRoleVO entityVO = new SysRoleVO();
					BeanUtils.copyProperties(entity,entityVO);
					voList.add(entityVO);
				}
		PageInfo<SysRoleVO> pageInfo = new PageInfo<SysRoleVO>(voList,pageData.getTotalCount(),pageData.getPageSize(),pageData.getCurrPage());
		return Result.ok().data(pageInfo);
	}

}
