package ${daoPackage};

import java.util.List;

import ${daoPackage}.base.BaseDAO;
import ${modelPackage}.${table.javaName};

public interface ${table.javaName}DAO extends BaseDAO<${table.javaName}, Long> {
	
	List<${table.javaName}> find${table.javaName}ByPage(int max, int min);

	List<${table.javaName}> get${table.javaName}ByPage();

}
