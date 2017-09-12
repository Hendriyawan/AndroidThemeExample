package com.gdev.learn.theme;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //createTheme
        ThemeUtils.createTheme(this);
        setContentView(R.layout.main);
        
        //toolbar
        setupToolbar(R.id.toolbar);
        //Button Theme Light
        Button light = (Button)findViewById(R.id.theme_light);
        Button dark = (Button)findViewById(R.id.theme_dark);
        light.setOnClickListener(this);
        dark.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
    	switch(v.getId())
        {
        	case R.id.theme_light:
            ThemeUtils.setTheme(this, 0);
            recreateActivity();
            break;
            
            case R.id.theme_dark:
            ThemeUtils.setTheme(this, 1);
            recreateActivity();
            break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //setupToolbar
    private void setupToolbar(int id)
    {
    	Toolbar toolbar = (Toolbar)findViewById(id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }
    
    //recreate/refresh Activity
    private void recreateActivity()
    {
    	this.finish();
        this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(new Intent(this, this.getClass()));
    }
}
