package condition;

import pojo.ConditionData;

import java.util.HashMap;
import java.util.Map;

public class Where {
    //列名常量定义
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_AGE = "age";
    public static final String COL_SCORE = "score";
    //操作符常量定义
    public static final String OPERATOR_BIGGER_THAN = ">";
    public static final String OPERATOR_SMALLER_THAN = "<";
    public static final String OPERATOR_EQUAL = "=";
    public static final String OPERATOR_BIGGER_AND_EQUAL = ">=";
    public static final String OPERATOR_SMALLER_AND_EQUAL = "<=";
    public static final String OPERATOR_NOT_EQUAL = "!=";
    //AND与OR常量定义
    public static final String RELATION_AND = "and";
    public static final String RELATION_OR = "or";

//    /**
//     *  目前只支持 and语法
//     * key做条件，value做条件判断
//     *  key格式样例 “id=1”
//     *  value 样例 “1” 、 "2:{id=1,name=张三}"
//     *  1:紧接上一个条件
//     *  2:指定并列条件
//     */
//    Map<String,String> condition=new HashMap();
//
//    public void addcondition(String key, String value){
//        condition.put(key,value);
//    }

    public Map<Integer,ConditionData> condition = new HashMap<Integer,ConditionData>();

    public void addCondition(Integer key,ConditionData value){

        condition.put(key, value);

    }




    public Where() {
    }
}
