package pojo;

import java.util.LinkedList;

public class ConditionData {
    /**
     * 每一个筛选条件当作一个链表节点
     */
    //带查询字段
    private String col;
    //查询操作（大于、小于、等于）
    private String operator;
    //查询字段的查询值
    private String value;
    //表示AND与OR
    private String relation;
    //指向并列的or分支条件
    private ConditionData selfNext;


    //创建包含or分支的condition
    public ConditionData(String col, String operator, String value, String relation, ConditionData selfNext) {
        this.col = col;
        this.operator = operator;
        this.value = value;
        this.relation = relation;
        this.selfNext = selfNext;
    }
    //创建非末尾条件
    public ConditionData(String col, String operator, String value, String relation) {
        this.col = col;
        this.operator = operator;
        this.value = value;
        this.relation = relation;
    }
    //创建最后一个条件
    public ConditionData(String col, String operator, String value) {
        this.col = col;
        this.operator = operator;
        this.value = value;
    }

    public String getCol() {
        return col;
    }

    public String getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

    public String getRelation() {
        return relation;
    }

    public ConditionData getSelfNext() {
        return selfNext;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setSelfNext(ConditionData selfNext) {
        this.selfNext = selfNext;
    }

    @Override
    public String toString() {
        return "ConditionData{" +
                "col='" + col + '\'' +
                ", operator='" + operator + '\'' +
                ", value='" + value + '\'' +
                ", relation='" + relation + '\'' +
                ", selfNext=" + selfNext +
                '}';
    }
}
