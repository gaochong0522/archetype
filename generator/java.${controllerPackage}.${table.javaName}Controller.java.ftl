package ${controllerPackage};

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
import ${modelPackage}.${table.javaName};
import ${servicePackage}.${table.javaName}Service;
import ${controllerPackage}.base.BaseController;

@RequestMapping(value = "/${table.name}")
@Controller
public class ${table.javaName}Controller extends BaseController {
	@Resource
	private ${table.javaName}Service ${table.name}Service;

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
			List<${table.javaName}> ${table.name}List = ${table.name}Service.find${table.javaName}ByPage(max,min);
			model.addAttribute("${table.name}List", ${table.name}List);
			return this.JSON;
		}else{
			List<${table.javaName}> ${table.name}List = ${table.name}Service.get${table.javaName}ByPage();
			this.setPagerData(${table.name}List);
		}
		return this.result(ResultType.FTL, "/${table.name}/${table.name}_list");
	}

	/**
	 * 跳转添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add",method=RequestMethod.GET)
	public String add(Model model) {
		return this.result(ResultType.FTL, "/${table.name}/${table.name}_form");
	}
	
	/**
	 * 添加
	 * @param model
	 * @param ${table.name}
	 * @return
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("${table.name}") ${table.javaName} ${table.name}) {
		model.addAttribute("model",${table.name});
		try {
			${table.name} = ${table.name}Service.save(${table.name});
			model.addAttribute("status", 0);
			model.addAttribute("info","添加成功！");

		} catch (Exception e) {
			model.addAttribute("status", -1);
			model.addAttribute("error","添加失败！");
		}
		
		return this.result(ResultType.FTL, "/${table.name}/${table.name}_form");
	}
	
	/**
	 * 跳转编辑页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}",method=RequestMethod.GET)
	public String edit(Model model,@PathVariable("id") long id) {
		${table.javaName} ${table.name} = ${table.name}Service.getById(id);
		model.addAttribute("model",${table.name});
		return this.result(ResultType.FTL, "/${table.name}/${table.name}_form");
	}
	/**
	 * 修改
	 * @param model
	 * @param ${table.name}
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method=RequestMethod.POST)
	public String doEdit(Model model, @PathVariable("id") long id ,@ModelAttribute("${table.name}") ${table.javaName} ${table.name}) {
		${table.name}.setId(id);
		model.addAttribute("model",${table.name});
		try {
			${table.name}Service.update(${table.name});
			model.addAttribute("status", 0);
			model.addAttribute("info","修改成功！");
		} catch (Exception e) {
			model.addAttribute("status", -1);
			model.addAttribute("error","修改失败！");
		}
		
		return this.result(ResultType.FTL, "/${table.name}/${table.name}_form");
	}
	/**
	 * 跳转详情
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}",method=RequestMethod.GET)
	public String detail(Model model,@PathVariable("id") long id) {
		${table.javaName} ${table.name} = ${table.name}Service.getById(id);
		model.addAttribute("${table.name}",${table.name});
		return this.result(ResultType.FTL, "/${table.name}/${table.name}_detail");
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") long id) {
		try {
			${table.name}Service.deleteById(id);
			model.addAttribute("status", 0);

		} catch (Exception e) {
			model.addAttribute("status", -1);
		}
		return this.JSON;
	}
}