package com.modules.system.controller;

import com.modules.common.annotation.IgnoreSecurity;
import com.modules.common.generator.utils.Result;
import com.modules.common.jwt.JwtUtils;
import com.modules.common.utils.PageInfo;
import com.modules.system.dbEntity.SysUserDB;
import com.modules.system.entity.SysRole;
import com.modules.system.entity.SysUser;
import com.modules.system.entity.SysUserRole;
import com.modules.system.form.SysUserForm;
import com.modules.system.query.SysUserQuery;
import com.modules.system.service.SysRoleService;
import com.modules.system.service.SysUserRoleService;
import com.modules.system.service.SysUserService;
import com.modules.system.vo.SysUserVO;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
* @author chen
* @date 2020-07-31 15:42:18
*/
@RestController
@RequestMapping("/sysUser")
@Api(value = "SysUserController", tags = {"SysUserController"}, description = "SysUserController")
public class SysUserController {
	@Resource
	private SysUserService sysUserService;
	@Resource
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Resource
	private SysUserRoleService sysUserRoleService;
	@Resource
	private SysRoleService sysRoleService;


	@GetMapping("/info")
	@ApiOperation(value = "根据token获取数据")
	@ApiResponses({
			@ApiResponse(code = 200, message = "返回数据", response = SysUserDB.class)
	})
	public Result info(HttpServletRequest request) {
		String token = request.getHeader("X-Token");
		SysUserDB sysUserDB = new SysUserDB();
		SysUser sysUser = sysUserService.getSysUserByToken(token);
		BeanUtils.copyProperties(sysUser,sysUserDB);
		List<SysUserRole> sysUserRoles = sysUserRoleService.listByUserId(sysUser.getId());
		SysRole sysRole = sysRoleService.get(sysUserRoles.get(0).getRoleId());
		sysUserDB.setRoles(sysRole);
		return Result.ok().data(sysUserDB);

	}


	@GetMapping("/get/{id}")
	@ApiImplicitParams({@ApiImplicitParam(name = "id",value = "id",defaultValue = "0")})
	@ApiOperation(value = "根据id获取数据")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = SysUserVO.class)
	})
	public Result get(@ApiParam(name = "id", value = "id", required = true) @PathVariable Long id) {
	 SysUser entity = sysUserService.get(id);
		if(entity == null){
			return Result.error("对象信息不存在！");
		}else{
			SysUserVO entityVO = new SysUserVO();
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
		int i = sysUserService.delete(id);
		return Result.ok().data(i);
	}

	@PostMapping("/add")
	@ApiOperation(value = "添加")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = Integer.class)
	})
	public Result add(@ApiParam(name="用户对象",value="传入json格式",required=true)@RequestBody SysUserForm form) {
		SysUser entity = new SysUser();
		BeanUtils.copyProperties(form,entity);
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		SysUser sysUser = sysUserService.findByUserName(entity.getUsername());
		if (sysUser!=null){
			return Result.error("用户名重复，请重新输入");
		}else {
			long i = sysUserService.insert(entity);
			return Result.ok().data(i);
		}
	}

	@PutMapping("/update")
	@ApiOperation(value = "更新")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = Integer.class)
	})
	public Result update(@ApiParam(name="用户对象",value="传入json格式",required=true)@RequestBody SysUserForm form) {
		SysUser entity = new SysUser();
		BeanUtils.copyProperties(form,entity);
		int i = sysUserService.update(entity.getId(),entity);
		return Result.ok().data(i);
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取所有数据分页列表")
	@ApiResponses({
	@ApiResponse(code = 200, message = "返回数据", response = SysUserVO.class, responseContainer = "List")
	})
	public Result page(@ApiParam(name="查询对象",value="传入json格式",required=true) SysUserQuery query, Integer page, Integer size) {
		page = page == null ? 1 : page;
		size = size == null ? 10 : size;
		PageInfo<SysUser> pageData = sysUserService.page(query,page,size);
		List<SysUser> list = pageData.getList();
			if(list == null){
			list = new ArrayList<>();
			}
		List<SysUserVO> voList = new ArrayList<SysUserVO>();
				for (SysUser entity : list) {
					SysUserVO entityVO = new SysUserVO();
					BeanUtils.copyProperties(entity,entityVO);
					voList.add(entityVO);
				}
		PageInfo<SysUserVO> pageInfo = new PageInfo<SysUserVO>(voList,pageData.getTotalCount(),pageData.getPageSize(),pageData.getCurrPage());
		return Result.ok().data(pageInfo);
	}

}
