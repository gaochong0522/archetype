package archetype.common.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 用于生成JFinal的SQL查询语句<br>
 
 * 类名称：Conditions<br>
 * 创建人：yangxp<br>
 * 创建时间：2014-1-19 上午11:22:26<br>
 * 
 * @version v1.0.9
 * 
 */

public class Conditions {

 

    public static final String EQUAL = "EQUAL"; // 相等

 

    public static final String NOT_EQUAL = "NOT_EQUAL"; // 不相等

 

    public static final String LESS_THEN = "LESS_THEN"; // 小于

 

    public static final String LESS_EQUAL = "LESS_EQUAL"; // 小于等于

 

    public static final String GREATER_EQUAL = "GREATER_EQUAL"; // 大于等于

 

    public static final String GREATER_THEN = "GREATER_THEN"; // 大于

 

    public static final String FUZZY = "FUZZY"; // 模糊匹配 %xxx%

 

    public static final String FUZZY_LEFT = "FUZZY_LEFT"; // 左模糊 %xxx

 

    public static final String FUZZY_RIGHT = "FUZZY_RIGHT"; // 右模糊 xxx%

 

    public static final String NOT_EMPTY = "NOT_EMPTY"; // 不为空值的情况

 

    public static final String EMPTY = "EMPTY"; // 空值的情况

 

    public static final String IN = "IN"; // 在范围内

 

    public static final String NOT_IN = "NOT_IN"; // 不在范围内

 

    // 用于接收SQL语句
    private ThreadLocal<String> sql = new ThreadLocal<String>();

 

    // 用于接收参数数组
    private ThreadLocal<ArrayList<Object>> paramList = new ThreadLocal<ArrayList<Object>>();

 

    // 用于存放设置的条件
    private ThreadLocal<Map<String, Object[]>> conditionMap = new ThreadLocal<Map<String, Object[]>>();

 

    // 用于存放需要排除的字段
    private ThreadLocal<Map<String, String>> excludeFieldMap = new ThreadLocal<Map<String, String>>();

 

    // 构造方法(表示没有设置查询类型的字段全部按照等于来处理)
    public Conditions() {
        conditionMap.set(new HashMap<String, Object[]>());
        excludeFieldMap.set(new HashMap<String, String>());
    }

 

    // 构造方法(设置后表示字段所有的查询方式按照设置类型来处理，除非后面针对字段的重新设置)
    public Conditions(String type) {
        Map<String, Object[]> map = new HashMap<String, Object[]>();
        map.put("GLOBALTYPE", new String[] { type });
        conditionMap.set(map);
        excludeFieldMap.set(new HashMap<String, String>());
    }

 




	




 




 




 



 



 



 



 




 



 

    public String getSql() {
        return sql.get();
    }

 

    public List<Object> getParamList() {
        return paramList.get();
    }
}

