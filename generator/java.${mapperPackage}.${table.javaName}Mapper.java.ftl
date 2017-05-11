package ${mapperPackage};

import java.util.List;

import org.apache.ibatis.annotations.Param;
import ${mapperPackage}.base.BaseMapper;
import ${modelPackage}.${table.javaName};

public interface ${table.javaName}Mapper extends BaseMapper<${table.javaName}, Long> {

	public List<${table.javaName}> find${table.javaName}(@Param("dataType") int dataType,@Param("max") int max, @Param("min") int min, @Param("pageSize") int pageSize);

	public List<${table.javaName}> get${table.javaName}ByPage();

}