package com.taras.application1;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//[Comment] Wrong bottom padding
//[Comment] Label "In work" is cutted off.
//[Comment] Dividers are too transparent
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_tittle, tv_status, tv_created, tv_created_date, tv_registered, tv_reg_date,
            tv_resolve, tv_resolve_date, tv_responsible, tv_resp_date, tv_note; //[Comment] Wrong names. Use google code style

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        makeToolbarAndArrow();
        makeRecyclerView();
        initListeners();
    }

    private void initViews() {
        tv_tittle = (TextView) findViewById(R.id.tv_tittle);
        tv_status = (TextView) findViewById(R.id.tv_status);
        tv_created = (TextView) findViewById(R.id.tv_created);
        tv_created_date = (TextView) findViewById(R.id.tv_created_date);
        tv_registered = (TextView) findViewById(R.id.tv_registered);
        tv_reg_date = (TextView) findViewById(R.id.tv_reg_date);
        tv_resolve = (TextView) findViewById(R.id.tv_resolve);
        tv_resolve_date = (TextView) findViewById(R.id.tv_resolve_date);
        tv_responsible = (TextView) findViewById(R.id.tv_responsible);
        tv_resp_date = (TextView) findViewById(R.id.tv_resp_date);
        tv_note = (TextView) findViewById(R.id.tv_note);
    }

    private void initListeners() {
        tv_tittle.setOnClickListener(this); //[Comment] Just findViewById(R.id.tv_tittle).setOnClickListener(this)
        tv_status.setOnClickListener(this);
        tv_created.setOnClickListener(this);
        tv_created_date.setOnClickListener(this);
        tv_registered.setOnClickListener(this);
        tv_reg_date.setOnClickListener(this);
        tv_resolve.setOnClickListener(this);
        tv_resolve_date.setOnClickListener(this);
        tv_responsible.setOnClickListener(this);
        tv_resp_date.setOnClickListener(this);
        tv_note.setOnClickListener(this);
    }

    private void makeToolbarAndArrow() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.toolbar_tittle);
        }
    }

    private void makeRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.card_view); //[Comment] without m. It's local variable

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false); //[Comment] without m. It's local variable
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] myDataset = {getString(R.string.first_image), getString(R.string.second_image)}; //[Comment] without m. It's local variable

        RecyclerView.Adapter mAdapter = new MyAdapter(myDataset); //[Comment] without m. It's local variable
        mRecyclerView.setAdapter(mAdapter);

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.activity_horizontal_margin);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_tittle:
                DialogUtils.show(getApplicationContext(), tv_tittle.getText().toString()); //[Comment] Wrong information. Control name is for Example TextView, ImageView
                break;
            case R.id.tv_status:
                DialogUtils.show(getApplicationContext(), tv_status.getText().toString());
                break;
            case R.id.tv_created:
                DialogUtils.show(getApplicationContext(), tv_created.getText().toString());
                break;
            case R.id.tv_created_date:
                DialogUtils.show(getApplicationContext(), tv_created_date.getText().toString());
                break;
            case R.id.tv_registered:
                DialogUtils.show(getApplicationContext(), tv_registered.getText().toString());
                break;
            case R.id.tv_reg_date:
                DialogUtils.show(getApplicationContext(), tv_reg_date.getText().toString());
                break;
            case R.id.tv_resolve:
                DialogUtils.show(getApplicationContext(), tv_resolve.getText().toString());
                break;
            case R.id.tv_resolve_date:
                DialogUtils.show(getApplicationContext(), tv_resolve_date.getText().toString());
                break;
            case R.id.tv_responsible:
                DialogUtils.show(getApplicationContext(), tv_responsible.getText().toString());
                break;
            case R.id.tv_resp_date:
                DialogUtils.show(getApplicationContext(), tv_resp_date.getText().toString());
                break;
            case R.id.tv_note:
                DialogUtils.show(getApplicationContext(), tv_note.getText().toString());
                break;
        //[Comment] Copy/Paste code
        }
    }

    public class ItemOffsetDecoration extends RecyclerView.ItemDecoration { //[Comment] It shouldn't be internal class

        private int mItemOffset;

        public ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if(i!=0) { //[Comment] wrong formatting
                    outRect.left = mItemOffset;
                }
            }
        }
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
