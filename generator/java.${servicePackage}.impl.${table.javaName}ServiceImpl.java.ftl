package ${servicePackage}.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${daoPackage}.${table.javaName}DAO;
import ${daoPackage}.base.BaseDAO;
import ${modelPackage}.${table.javaName};
import ${servicePackage}.${table.javaName}Service;
import ${servicePackage}.base.impl.BaseServiceImpl;

@Service
public class ${table.javaName}ServiceImpl extends BaseServiceImpl<${table.javaName},Long>  implements ${table.javaName}Service{
	@Resource
	private ${table.javaName}DAO ${table.name}DAO;
	
	@Override
	public BaseDAO<${table.javaName}, Long> getBaseDAO() {
		return ${table.name}DAO;
	}
	
	@Override
	public List<${table.javaName}> find${table.javaName}ByPage(int max, int min) {
		return ${table.name}DAO.find${table.javaName}ByPage(max, min);
	}

	@Override
	public List<${table.javaName}> get${table.javaName}ByPage() {
		return ${table.name}DAO.get${table.javaName}ByPage();
	}

}