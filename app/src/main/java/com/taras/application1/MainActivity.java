package com.taras.application1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListeners();
        makeToolbarAndArrow();
        makeRecyclerView();
    }

    private void initListeners() {
        findViewById(R.id.tv_tittle).setOnClickListener(this);
        findViewById(R.id.tv_status).setOnClickListener(this);
        findViewById(R.id.tv_created).setOnClickListener(this);
        findViewById(R.id.tv_created_date).setOnClickListener(this);
        findViewById(R.id.tv_registered).setOnClickListener(this);
        findViewById(R.id.tv_reg_date).setOnClickListener(this);
        findViewById(R.id.tv_resolve).setOnClickListener(this);
        findViewById(R.id.tv_resolve_date).setOnClickListener(this);
        findViewById(R.id.tv_responsible).setOnClickListener(this);
        findViewById(R.id.tv_resp_date).setOnClickListener(this);
        findViewById(R.id.tv_note).setOnClickListener(this);
    }

    private void makeToolbarAndArrow() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.toolbar_tittle);
        }
    }

    private void makeRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_view);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] myDataset = {getString(R.string.first_image),
                getString(R.string.second_image)};

        RecyclerView.Adapter adapter = new RecyclerAdapter(myDataset);
        recyclerView.setAdapter(adapter);

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.activity_horizontal_margin);
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), v.getId() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
