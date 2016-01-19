package com.example.dongja94.samplerecyclerheaderview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeaderAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        mAdapter = new HeaderAdapter();
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initData();
    }

    private void initData() {
        View header = getLayoutInflater().inflate(R.layout.view_header, null);
        mAdapter.addHeader(header, null, false);
        for (int i = 0; i < 40 ; i++) {
            mAdapter.add("item : " + i);
        }
    }
}
