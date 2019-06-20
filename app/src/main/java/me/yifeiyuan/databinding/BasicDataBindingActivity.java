package me.yifeiyuan.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.yifeiyuan.databinding.databinding.BasicDatabindingBinding;

public class BasicDataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BasicDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.basic_databinding);

        Student student = new Student();
        student.name = "程序亦非猿";

        binding.setStudent(student);
    }

//    public void getRootFromBinding() {
//        BasicDatabindingBinding binding = BasicDatabindingBinding.inflate(getLayoutInflater());
//        View root = binding.getRoot();
//
//        DataBindingUtil.inflate(getLayoutInflater(), R.layout.basic_databinding, viewGroup, false);
//    }

}
