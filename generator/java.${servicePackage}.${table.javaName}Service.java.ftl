package ${servicePackage};

import java.util.List;

import ${modelPackage}.${table.javaName};
import ${servicePackage}.base.BaseService;

public interface ${table.javaName}Service extends BaseService<${table.javaName}, Long>{

	List<${table.javaName}> find${table.javaName}ByPage(int max, int min);

	List<${table.javaName}> get${table.javaName}ByPage();

}
