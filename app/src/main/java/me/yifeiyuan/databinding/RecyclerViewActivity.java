package me.yifeiyuan.databinding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.yifeiyuan.databinding.databinding.RvItemBinding;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.list);

        recyclerView.setAdapter(new MAdapter());
    }

    private class MAdapter extends RecyclerView.Adapter {

        List<Student> data = new ArrayList<>();

        public MAdapter() {
            for (int i = 0; i < 10; i++) {
                Student student = Student.create();
                student.age = student.age + i;
                student.name = student.name + i;
                data.add(student);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            VH vh = new VH(layoutInflater.inflate(R.layout.rv_item, viewGroup, false));
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
            VH vh = (VH) viewHolder;
            vh.binding.setStudent(data.get(i));
            vh.binding.executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    private class VH extends RecyclerView.ViewHolder {

        RvItemBinding binding;

        public VH(@NonNull final View itemView) {
            super(itemView);
            binding = RvItemBinding.bind(itemView);
        }
    }
}
