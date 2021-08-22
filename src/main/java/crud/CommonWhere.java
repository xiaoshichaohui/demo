package crud;

import condition.Where;
import pojo.ConditionData;
import pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonWhere {

    public static List<Student> doWhere(List<Student> studentList, Where where){

        if (studentList==null) {
            return new ArrayList<>();
        }

        if (where!=null){
            Map<Integer, ConditionData> condi = where.condition;
            int size = condi.entrySet().size();
            //便利获取where中的查询条件
            for (int i=0;i<size;i++){

                List<Student> res = new ArrayList<Student>();
                ConditionData data = condi.get(i);
                if (data!=null){
                    //不同的字段使用switch条件
                    switch (data.getCol()){
                        //字段id处理

                        case Where.COL_ID:{

                            Integer value= Integer.parseInt(data.getValue());
                            if (data.getOperator().equals(Where.OPERATOR_EQUAL)){



                                studentList.stream()
                                        .filter(student -> student.getId().equals(value))
                                        .forEach(student -> res.add(student));
                            }
                            if (data.getOperator().equals(Where.OPERATOR_BIGGER_THAN)) {

                                studentList.stream()
                                        .filter(student -> student.getId() > value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_SMALLER_THAN)) {

                                studentList.stream()
                                        .filter(student -> student.getId() < value)
                                        .forEach(student -> res.add(student));

                            }

                            if (data.getOperator().equals(Where.OPERATOR_BIGGER_AND_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> student.getId() >= value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_SMALLER_AND_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> student.getId() <= value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_NOT_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> !student.getId().equals(value))
                                        .forEach(student -> res.add(student));

                            }
                            List<Student> temp = new ArrayList<>();
                            if (res!=null){
                                for (Student s : res){
                                    temp.add(s);

                                }
                                studentList = temp;
                            }


                        }
                        case Where.COL_AGE:{

                            Integer value = Integer.parseInt(data.getValue());
                            if (data.getOperator().equals(Where.OPERATOR_EQUAL)){

                                studentList.stream()
                                        .filter(student -> student.getAge().equals(value))
                                        .forEach(student -> res.add(student));
                            }
                            if (data.getOperator().equals(Where.OPERATOR_BIGGER_THAN)) {

                                studentList.stream()
                                        .filter(student -> student.getAge() > value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_SMALLER_THAN)) {

                                studentList.stream()
                                        .filter(student -> student.getAge() < value)
                                        .forEach(student -> res.add(student));

                            }

                            if (data.getOperator().equals(Where.OPERATOR_BIGGER_AND_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> student.getAge() >= value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_SMALLER_AND_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> student.getAge() <= value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_NOT_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> !student.getAge().equals(value))
                                        .forEach(student -> res.add(student));

                            }
                            List<Student> temp = new ArrayList<>();
                            if (res!=null){
                                for (Student s : res){
                                    temp.add(s);

                                }
                                studentList.clear();
                                studentList = temp;
                            }


                        }
                        case Where.COL_NAME:{
                            String nameValue = data.getValue();
                            if (data.getOperator().equals(Where.OPERATOR_EQUAL)){

                                studentList.stream()
                                        .filter(student -> student.getName().equals(nameValue))
                                        .forEach(student -> res.add(student));
                            }
                            if (data.getOperator().equals(Where.OPERATOR_NOT_EQUAL)){

                                studentList.stream()
                                        .filter(student -> !student.getName().equals(nameValue))
                                        .forEach(student -> res.add(student));
                            }

                            List<Student> temp = new ArrayList<>();
                            if (res!=null){
                                for (Student s : res){
                                    temp.add(s);

                                }
                                studentList = temp;
                            }



                        }
                        case Where.COL_SCORE:{
                            Integer value= Integer.parseInt(data.getValue());
                            if (data.getOperator().equals(Where.OPERATOR_EQUAL)){

                                studentList.stream()
                                        .filter(student -> student.getScore().equals(value))
                                        .forEach(student -> res.add(student));
                            }
                            if (data.getOperator().equals(Where.OPERATOR_BIGGER_THAN)) {

                                studentList.stream()
                                        .filter(student -> student.getScore() > value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_SMALLER_THAN)) {

                                studentList.stream()
                                        .filter(student -> student.getScore() < value)
                                        .forEach(student -> res.add(student));

                            }

                            if (data.getOperator().equals(Where.OPERATOR_BIGGER_AND_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> student.getScore() >= value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_SMALLER_AND_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> student.getScore() <= value)
                                        .forEach(student -> res.add(student));

                            }
                            if (data.getOperator().equals(Where.OPERATOR_NOT_EQUAL)) {

                                studentList.stream()
                                        .filter(student -> !student.getScore().equals(value))
                                        .forEach(student -> res.add(student));

                            }
                            List<Student> temp = new ArrayList<>();
                            if (res!=null){
                                for (Student s : res){
                                    temp.add(s);

                                }
                                studentList = temp;
                            }


                        }

                        default:


                    }

                }


            }

        }




        return studentList;

    }
}
