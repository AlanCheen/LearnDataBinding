package me.yifeiyuan.databinding.inactivity;

import android.view.View;
import android.widget.Toast;

import me.yifeiyuan.databinding.model.Student;
/**
 * Created by mingjue on 2019-06-21.
 *
 * https://developer.android.com/topic/libraries/data-binding/expressions.html#listener_bindings
 */
public class EventHandler {

    //@{()->handler.onShowToast}
    public void onShowToast(View view) {
        Toast.makeText(view.getContext(), "哎哟，大佬带带我！！", Toast.LENGTH_SHORT).show();
    }

    public void onShowStudentName(View view, Student student) {
        Toast.makeText(view.getContext(), student.name, Toast.LENGTH_SHORT).show();
    }
}
