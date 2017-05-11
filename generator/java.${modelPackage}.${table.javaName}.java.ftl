package ${modelPackage};

import java.io.Serializable;
${table.javaImport}

[#if table.comment?length gt 0 ]
/**
*${table.comment}
*/
[/#if]
public class ${table.javaName} extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;

[#list table.cloumnList as cloumn ]
[#if cloumn.name!="id"]
	[#if cloumn.comment?length gt 0 ]
	/**
	* ${cloumn.comment}
	*/
	[/#if]
	private ${cloumn.javaTypeName} ${cloumn.name} ;
[/#if]
[/#list]


[#list table.cloumnList as cloumn ]
[#if cloumn.name!="id"]
	[#if cloumn.comment?length gt 0 ]
	/**
	* ${cloumn.comment}
	*/
	[/#if]
	public ${cloumn.javaTypeName} get${cloumn.javaName}() {
			return this.${cloumn.name};
	}
	[#if cloumn.comment?length gt 0 ]
	/**
	* ${cloumn.comment}
	*/
	[/#if]
	public void set${cloumn.javaName}(${cloumn.javaTypeName} ${cloumn.name}) {
			this.${cloumn.name} = ${cloumn.name};
	}
[/#if]		
[/#list]
}