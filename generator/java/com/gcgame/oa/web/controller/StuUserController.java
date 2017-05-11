package com.gcgame.oa.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import com.fchgame.oa.common.util.web.MyThreadLocalUtils;
import com.zmtech.common.util.validator.ZmValidationUtils;
import com.zmtech.common.web.viewresolver.ResultType;
import com.gcgame.oa.model.StuUser;
import com.gcgame.oa.service.StuUserService;
import com.gcgame.oa.web.controller.base.BaseController;

@RequestMapping(value = "/stuUser")
@Controller
public class StuUserController extends BaseController {
	@Resource
	private StuUserService stuUserService;

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(Model model) {
 		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		String viewType = getViewType();
		if(this.JSON.equalsIgnoreCase(viewType)){//手机接口调用
			int max = 0 ;
			int min = 0 ;
			String maxId = request.getParameter("maxId");
			String minId = request.getParameter("minId");
			if(NumberUtils.isNumber(minId)){
				min = Integer.parseInt(minId);
			}
			if(min==0&&NumberUtils.isNumber(maxId)){
				max = Integer.parseInt(maxId);
			}
			List<StuUser> stuUserList = stuUserService.findStuUserByPage(max,min);
			model.addAttribute("stuUserList", stuUserList);
			return this.JSON;
		}else{
			List<StuUser> stuUserList = stuUserService.getStuUserByPage();
			this.setPagerData(stuUserList);
		}
		return this.result(ResultType.JSP, "/stuUser/stuUser_list");
	}

	/**
	 * 跳转添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add",method=RequestMethod.GET)
	public String add(Model model) {
		return this.result(ResultType.JSP, "/stuUser/stuUser_form");
	}
	
	/**
	 * 添加
	 * @param model
	 * @param stuUser
	 * @return
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("stuUser") StuUser stuUser) {
		model.addAttribute("model",stuUser);
		try {
			stuUser = stuUserService.save(stuUser);
			model.addAttribute("status", 0);
			model.addAttribute("info","添加成功！");

		} catch (Exception e) {
			model.addAttribute("status", -1);
			model.addAttribute("error","添加失败！");
		}
		
		return this.result(ResultType.JSP, "/stuUser/stuUser_form");
	}
	
	/**
	 * 跳转编辑页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}",method=RequestMethod.GET)
	public String edit(Model model,@PathVariable("id") long id) {
		StuUser stuUser = stuUserService.getById(id);
		model.addAttribute("model",stuUser);
		return this.result(ResultType.JSP, "/stuUser/stuUser_form");
	}
	/**
	 * 修改
	 * @param model
	 * @param stuUser
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method=RequestMethod.POST)
	public String doEdit(Model model, @PathVariable("id") long id ,@ModelAttribute("stuUser") StuUser stuUser) {
		stuUser.setId(id);
		model.addAttribute("model",stuUser);
		try {
			stuUserService.update(stuUser);
			model.addAttribute("status", 0);
			model.addAttribute("info","修改成功！");
		} catch (Exception e) {
			model.addAttribute("status", -1);
			model.addAttribute("error","修改失败！");
		}
		
		return this.result(ResultType.JSP, "/stuUser/stuUser_form");
	}
	/**
	 * 跳转详情
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}",method=RequestMethod.GET)
	public String detail(Model model,@PathVariable("id") long id) {
		StuUser stuUser = stuUserService.getById(id);
		model.addAttribute("stuUser",stuUser);
		return this.result(ResultType.JSP, "/stuUser/stuUser_detail");
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") long id) {
		try {
			stuUserService.deleteById(id);
			model.addAttribute("status", 0);

		} catch (Exception e) {
			model.addAttribute("status", -1);
		}
		return this.JSON;
	}
}