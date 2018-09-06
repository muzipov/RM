package ru.britishdesign.rm;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class GeneralActivity extends AppCompatActivity {
    private static final int LAYOUT = R.layout.activity_general;
    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanseState){
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanseState);
        setContentView(LAYOUT);
    }
}
