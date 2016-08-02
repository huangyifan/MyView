package com.example.huang.myview;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyView extends Activity {

    TopBar mTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);

        mTopBar = (TopBar) findViewById(R.id.topBar);

        //mTopBar.setButtonVisable(0,false);
        mTopBar.setTitle("修改标题");

        bindListener();

    }

    private void bindListener() {
        mTopBar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MyView.this,"left",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MyView.this,"right",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
