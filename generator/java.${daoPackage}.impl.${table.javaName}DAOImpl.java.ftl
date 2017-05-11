package ${daoPackage}.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import ${daoPackage}.${table.javaName}DAO;
import ${daoPackage}.base.impl.BaseDAOImpl;
import ${mapperPackage}.base.BaseMapper;
import ${mapperPackage}.${table.javaName}Mapper;
import ${modelPackage}.${table.javaName};
import com.zmtech.common.page.imp.Page;

@Repository
public class ${table.javaName}DAOImpl extends BaseDAOImpl<${table.javaName},Long> implements ${table.javaName}DAO {

	@Resource
	private ${table.javaName}Mapper ${table.name}Mapper;

	@Override
	public BaseMapper<${table.javaName}, Long> getMapper() {
		return ${table.name}Mapper;
	}

	@Override
	public List<${table.javaName}> find${table.javaName}ByPage(int max, int min) {
		 int pageSize = Page.threadLocal.get().getPageSize();
		 int dataType = this.getDataType();
		return ${table.name}Mapper.find${table.javaName}(dataType,max, min,pageSize);
	}

	@Override
	public List<${table.javaName}> get${table.javaName}ByPage() {
		return ${table.name}Mapper.get${table.javaName}ByPage();
	}
	
}
