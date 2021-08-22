package condition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderBy {

    /**
     *     ascOrDsc为排序种类，取值为CommonValue.ORDER_BY_ASC或者CommonValue.ORDER_BY_DSC
     *     condition为排序字段数组
     */
    private String ascOrDsc;
    private List<String> condition;


    public String getAscOrDsc() {
        return ascOrDsc;
    }

    public List<String> getCondition() {
        return condition;
    }

    public void setAscOrDsc(String ascOrDsc) {
        this.ascOrDsc = ascOrDsc;
    }

    public void setCondition(List<String> condition) {
        this.condition = condition;
    }



    public void addCondition(String c){

        this.condition.add(c);



    }

    public OrderBy() {
        if (condition==null){

            condition = new ArrayList<String>();

        }

    }
}
