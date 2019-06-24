package me.yifeiyuan.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;

import me.yifeiyuan.databinding.BR;
/**
 * Created by mingjue on 2019-06-19.
 */
public class Student extends BaseObservable {

    public String name;
    public int age;
    public int gender;
    public boolean graduate;

    //ObservableField 可以实现双向绑定
    public ObservableInt weight = new ObservableInt(70);

    public Student deskMate;

    public static Student create() {
        Student student = new Student();
        student.name = "程序亦非猿";
        student.age = 17;
        student.gender = 0;
        student.weight = new ObservableInt(70);

        Student deskMate = new Student();
        deskMate.name = "菩提本无树";
        deskMate.age = 66;
        student.gender = 1;

        student.deskMate = deskMate;
        return student;
    }

    public void becomeOlder() {
        age++;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public boolean isMale() {
        return gender == 0;
    }

    public boolean isGraduate() {
        return graduate;
    }

    public void loseWeight() {
        int pre = weight.get();
        weight.set(--pre);
    }

    public void addWeight() {
        int pre = weight.get();
        weight.set(++pre);
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
