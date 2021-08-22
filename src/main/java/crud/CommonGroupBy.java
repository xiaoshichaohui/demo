package crud;

import condition.GroupBy;
import condition.Limit;
import pojo.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonGroupBy {

    /**
     *
     * @param studentList
     * @param groupBy
     * @return 分组条件为key，分组结果List<Student>为结果的map
     */
    public static List<Student> doGruopBy(List<Student> studentList, GroupBy groupBy){


        Map<String,List<Student>> listList = new HashMap<>();

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

        List<Student> result = new ArrayList<>();
//        List<Student> result = new ArrayList<>();
        for (Map.Entry<String, List<Student>> entry : listList.entrySet()) {
            for (Student student : entry.getValue()){

                result.add(student);
            }
        }

        return result;
    }

}
