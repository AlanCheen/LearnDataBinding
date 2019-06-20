package me.yifeiyuan.databinding;

/**
 * Created by mingjue on 2019-06-19.
 */
public class Student {

    public String name;
    public int age;
    public Student deskMate;

    public static Student create() {
        Student student = new Student();
        student.name = "程序亦非猿";
        student.age = 18;

        Student deskMate = new Student();
        deskMate.name = "菩提本无树";
        deskMate.age = 66;

        student.deskMate = deskMate;
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", deskMate=" + deskMate +
                '}';
    }
}
