package me.yifeiyuan.databinding;

/**
 * Created by mingjue on 2019-06-19.
 */
public class Student {

    public String name;
    public int age;
    public Student deskMate;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", deskMate=" + deskMate +
                '}';
    }
}
