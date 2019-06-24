package me.yifeiyuan.databinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.yifeiyuan.databinding.inactivity.BasicDataBindingActivity;
import me.yifeiyuan.databinding.infragment.FragmentDBActivity;
import me.yifeiyuan.databinding.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        RecyclerView list = findViewById(R.id.list);

        final List<TestItem> items = new ArrayList<>();

        addTestCase(items);

        list.setAdapter(new Adapter() {
            @NonNull
            @Override
            public TestVH onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
                TestVH vh = new TestVH(getLayoutInflater().inflate(R.layout.item_main, viewGroup, false));
                return vh;
            }

            @Override
            public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

                TestVH vh = (TestVH) viewHolder;

                TextView textView = vh.itemView.findViewById(R.id.tv_);
                final TestItem item = items.get(i);
                textView.setText(item.text);

                viewHolder.itemView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        MainActivity.this.startActivity(new Intent(MainActivity.this, item.target));
                    }
                });
            }

            @Override
            public int getItemCount() {
                return items.size();
            }
        });
    }

    private void addTestCase(final List<TestItem> items) {
        items.add(TestItem.create("在 Activity中使用 DataBinding，基础运用", BasicDataBindingActivity.class));
        items.add(TestItem.create("在 Fragment DataBinding，基础运用", FragmentDBActivity.class));
        items.add(TestItem.create("结合 RecyclerView 使用 DataBinding", RecyclerViewActivity.class));
    }

    private static class TestItem {

        public String text;

        public Class<? extends Activity> target;

        public TestItem(final String text, final Class<? extends Activity> target) {
            this.text = text;
            this.target = target;
        }

        public static TestItem create(String text, Class<? extends Activity> target) {
            return new TestItem(text, target);
        }
    }

    private class TestVH extends ViewHolder {

        public TestVH(@NonNull final View itemView) {
            super(itemView);
        }
    }
}
