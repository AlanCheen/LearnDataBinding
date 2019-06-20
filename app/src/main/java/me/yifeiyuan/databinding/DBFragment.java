package me.yifeiyuan.databinding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import me.yifeiyuan.databinding.databinding.FragmentDbBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DBFragment extends Fragment {

    public DBFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final FragmentDbBinding binding = FragmentDbBinding.inflate(getLayoutInflater(), container, false);
        final Student student = Student.create();
        binding.setStudent(student);

        View root = binding.getRoot();

        root.findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                student.age = student.age + 1;
                //如果不重新设置的话 不会刷新，因为目前是单向的绑定
                binding.setStudent(student);
            }
        });

        return root;
    }

}
