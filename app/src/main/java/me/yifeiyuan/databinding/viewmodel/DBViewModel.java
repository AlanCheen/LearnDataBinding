package me.yifeiyuan.databinding.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import me.yifeiyuan.databinding.model.Student;
/**
 * Created by mingjue on 2019-06-21.
 */
public class DBViewModel extends ViewModel implements Observable {

    public MutableLiveData<Student> student = new MutableLiveData<>();

    private PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

    @Override
    public void addOnPropertyChangedCallback(final OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(final OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }
}
