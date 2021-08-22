package crud;

import condition.GroupBy;
import condition.Limit;
import condition.OrderBy;
import pojo.ConditionData;
import pojo.Student;
import condition.Where;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SqlCrud {
    public static void main(String[] args){

        //模拟待查询数据
        List<Student> studentList = Utils.getData(100);
        //where条件设定
        Where where = new Where();
        where.condition.put(0,new ConditionData(Where.COL_ID,Where.OPERATOR_BIGGER_AND_EQUAL,"20"));
        where.condition.put(1,new ConditionData(Where.COL_SCORE,Where.OPERATOR_BIGGER_THAN,"70"));
        //orderBy条件设定
        OrderBy orderBy = new OrderBy();
        orderBy.setAscOrDsc(CommonValue.ORDER_BY_DSC);
        List<String> colList = new ArrayList<>();
        colList.add(CommonValue.COL_SCORE);
        orderBy.setCondition(colList);


        //groupBy条件设定

        GroupBy groupBy = new GroupBy();
        //多列分组需添加多次条件
        groupBy.addCondi(CommonValue.COL_AGE);

        //设定limit数量
        Limit limit = new Limit();
        limit.setSize(5);





        SqlCrud sqlCrud = new SqlCrud();
        List<Student> students = sqlCrud.select(studentList, where,orderBy,groupBy,limit);
//        List<Student> students= CommonWhere.doWhere(studentList, where);
        System.out.println(students);
        System.out.println(students.size());

    }

    public List<Student> select(List<Student> studentList, Where where, OrderBy orderBy, GroupBy groupBy, Limit limit){

        List<Student> result = new ArrayList<>();
        List<Student> whereResult= CommonWhere.doWhere(studentList, where);
        List<Student> orderByResult = CommonOrderBy.doOrderBy(whereResult,orderBy);
        List<Student> groupResult = CommonGroupBy.doGruopBy(orderByResult,groupBy);
        groupResult.stream().limit(limit.getSize()).forEach(student ->
                result.add(student)

                );

        return result;
    }




}
