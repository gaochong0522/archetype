package test;

import com.zmtech.common.util.codegen.api.GeneratorConfig;

public class GenCode extends GeneratorConfig{
	protected void initConfig() {
		String str = (str = System.getProperty("user.dir")).substring(
				str.lastIndexOf('\\') + 1, str.length());
		
//		setUrl("jdbc:mysql://223.100.6.179:23306/railoa_new?characterEncoding=UTF-8");
		setUrl("jdbc:mysql://localhost:3306/studentper?serverTimezone=UTC");
//		setUrl("jdbc:oracle:thin:@223.100.6.179:1521:BCCWD");
//		setDriveClass("oracle.jdbc.driver.OracleDriver");
		setDriveClass("com.mysql.cj.jdbc.Driver");
		setUsername("root");

//		setPassword("XZHSOFT-0729");
		setPassword("1234qwer");
//
		setTemplatePath("generator");

//		setTableNamePattern("user_right");
		setTableNamePattern("stu_user");

		setExcludedTableNamePattern("sequence");

		setTablePrefix("r_|t_");
		
//		getData().put("modelPackage", "com.zmtech." + str + ".model.main");
		getData().put("modelPackage", "com.gcgame.oa.model");

//		getData().put("mapperPackage", "com.zmtech." + str + ".mapper");
		getData().put("mapperPackage", "com.gcgame.oa.mapper");

//		getData().put("daoPackage", "com.zmtech." + str + ".dao");
		getData().put("daoPackage", "com.gcgame.oa.dao");

//		getData().put("servicePackage", "com.zmtech." + str + ".service");
		getData().put("servicePackage", "com.gcgame.oa.service");
		
//		getData().put("controllerPackage", "com.zmtech." + str + ".web.controller");
		getData().put("controllerPackage", "com.gcgame.oa.web.controller");
	}

	public static void main(String[] paramArrayOfString) {
		new GenCode().generatorCode();
	}
}
