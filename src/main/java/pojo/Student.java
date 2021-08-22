package pojo;

import java.util.Objects;

/**
 *
 * 数据库存储的实体类
 */
public class Student implements Comparable{
    //数据记录id
    private Integer id;

    //姓名
    private String name;
    //年龄
    private Integer age;
    //成绩
    private Integer score;



    public Integer getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getScore() {
        return score;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&  Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(score, student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  name, age, score);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
