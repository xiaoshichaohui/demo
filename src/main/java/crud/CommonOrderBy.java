package crud;

import condition.OrderBy;
import pojo.Student;

import javax.xml.crypto.AlgorithmMethod;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonOrderBy {

    public static List<Student> doOrderBy(List<Student> studentList, OrderBy orderBy) {

        String col = orderBy.getCondition().get(0);
        col = "get"+col.substring(0, 1).toUpperCase() + col.substring(1);
        String sign = orderBy.getAscOrDsc();
        if (sign == null || col==null) {
            return studentList;
        }


        String finalCol = col;
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Method m = null;

                try {
                    m = Student.class.getDeclaredMethod(finalCol);

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }


                try {
                    assert m != null;
                    if ((int)m.invoke(o1)>(int)m.invoke(o2)){
                        if (sign==CommonValue.ORDER_BY_ASC){
                            return 1;
                        }
                        if (sign==CommonValue.ORDER_BY_DSC){
                            return -1;
                        }

                    }else if ((int)m.invoke(o1)==(int)m.invoke(o2)){

                        return 0;

                    }else {
                        if (sign==CommonValue.ORDER_BY_ASC){
                            return -1;
                        }
                        if (sign==CommonValue.ORDER_BY_DSC){
                            return 1;
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return 1;
            }
        });
        return studentList;
    }

}
