package me.yifeiyuan.databinding.model;

import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import java.util.List;
/**
 * Created by mingjue on 2019-06-21.
 */
public class Teacher implements Observable {

    List<Student> students;

    PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

    @Override
    public void addOnPropertyChangedCallback(final OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(final OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }
}
