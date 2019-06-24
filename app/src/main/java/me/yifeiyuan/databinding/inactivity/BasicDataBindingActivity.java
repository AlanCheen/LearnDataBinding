package me.yifeiyuan.databinding.inactivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.yifeiyuan.databinding.R;
import me.yifeiyuan.databinding.model.Student;
import me.yifeiyuan.databinding.databinding.BasicDatabindingBinding;

/**
 * 展示 DataBinding 的基础能力
 *
 * - 基本的表达式
 * - 事件处理
 *
 *
 *
 */
public class BasicDataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BasicDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.basic_databinding);

        Student student = Student.create();
        //设置给 Binding 不然没数据
        binding.setStudent(student);

        //需要设置 Handler，不然不会调用哟
        binding.setHandler(new EventHandler());

    }
}
