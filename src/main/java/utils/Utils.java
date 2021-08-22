package utils;

import pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    //生成模拟表数据
    public static List<Student> getData(int total){


        List<Student> data = new ArrayList<Student>();

        for(int i=0;i<total;i++){
            Student stu = new Student();
            stu.setId(i+1);
            stu.setAge(10+(int)(Math.random()*10));
            stu.setScore(50+(int)(Math.random()*50));
            stu.setName("张"+ (i+1) + "山");
            data.add(stu);

        }


        return data;
    }


}
