import condition.GroupBy;
import condition.OrderBy;
import condition.Where;
import crud.CommonGroupBy;
import crud.CommonOrderBy;
import crud.CommonValue;
import crud.CommonWhere;
import org.junit.Test;
import pojo.ConditionData;
import pojo.Student;
import utils.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilTest {

    //where测试
    @Test
    public void test(){

        List<Student> studentList = Utils.getData(10);
        System.out.println(studentList);
        List<Student> list = new ArrayList<Student>();
        Where where = new Where();
        where.condition.put(0,new ConditionData(Where.COL_SCORE,Where.OPERATOR_BIGGER_AND_EQUAL,"80"));
        where.condition.put(1,new ConditionData(Where.COL_ID,Where.OPERATOR_SMALLER_THAN,"8"));
        List<Student> list1 = CommonWhere.doWhere(studentList, where);

        System.out.println(list1);

    }
    //where测试
    @Test
    public void testCondition(){

        Where where = new Where();
        where.addCondition(0,new ConditionData(Where.COL_AGE,Where.OPERATOR_BIGGER_AND_EQUAL,"15"));
        where.addCondition(1,new ConditionData(Where.COL_SCORE,Where.OPERATOR_SMALLER_AND_EQUAL,"60"));
        System.out.println(where.condition.entrySet().size());

        System.out.println(where.condition.get(0));
        System.out.println(where.condition.get(1));

        System.out.println(Integer.parseInt(where.condition.get(1).getValue()));

    }
    //groupBy测试
    @Test
    public void testGroup(){
        List<Student> studentList = Utils.getData(100);
        Map<String,List<Student>> listList = new HashMap<>();

        GroupBy groupBy = new GroupBy();

        groupBy.addCondi(CommonValue.COL_AGE);
//        groupBy.addCondi(CommonValue.COL_SCORE);
//        groupBy.addCondi(CommonValue.COL_NAME);


        listList = studentList.stream().collect(Collectors.groupingBy(student ->
        {
            String stringResult = "";
            for (String s : groupBy.getGruopCon()){

                String temp = "get"+s.substring(0, 1).toUpperCase() + s.substring(1);//getAge
                if (stringResult.equals("")){


                    try {
                        Method m = student.getClass().getDeclaredMethod(temp);
                        stringResult = m.invoke(student)+"";
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }else {
                    try {

                        Method m = student.getClass().getDeclaredMethod(temp);
                        stringResult =stringResult+"_"+m.invoke(student);

                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }


            }
            return stringResult;
        }));
        System.out.println(listList);
        System.out.println(listList.size());
        List<Student> result = new ArrayList<>();
        for (Map.Entry<String, List<Student>> entry : listList.entrySet()) {
            for (Student student : entry.getValue()){

                result.add(student);
            }
        }
        System.out.println(result);


    }

    @Test
    public void testClass() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Student> studentList = Utils.getData(100);
        Map<String,List<Student>> listList = new HashMap<>();

        GroupBy groupBy = new GroupBy();

        groupBy.addCondi(CommonValue.COL_AGE);

        List<Student> stringListMap = CommonGroupBy.doGruopBy(studentList, groupBy);


        System.out.println(stringListMap);

    }

    //测试orderBy
    @Test
    public void testOrderBy() throws Exception{
        List<Student> studentList = Utils.getData(10);

        OrderBy orderBy = new OrderBy();
        orderBy.setAscOrDsc(CommonValue.ORDER_BY_ASC);
        List<String> condition = orderBy.getCondition();
        condition.add(CommonValue.COL_AGE);
        orderBy.setCondition(condition);
        List<Student> list = CommonOrderBy.doOrderBy(studentList, orderBy);
        System.out.println(list);
        List<Student> result = new ArrayList<>();
        studentList.stream().limit(4).forEach(student ->
                result.add(student)

                );
        System.out.println(result);
        System.out.println(result.size());



//        List<Student> list = sorted.collect(Collectors.toList());
//        System.out.println(list);

    }

    @Test
    public void testFun() throws Exception{
        Student student = new Student();
        student.setName("sch");
        student.setAge(20);
        student.setScore(90);
        System.out.println(student.getScore());
        System.out.println(Student.class.getDeclaredMethod("getScore").invoke(student));
        Function<Student, Integer> getScore = Student::getScore;




    }

}
