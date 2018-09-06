package ru.britishdesign.rm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Settings extends AppCompatActivity {
    private static final int LAYOUT = R.layout.settings;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanseState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanseState);
        setContentView(LAYOUT);

        initToolBar();
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_settings);
        // своя навигационная иконка
        // toolbar.setNavigationIcon(R.drawable.magnify);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.settings);
        //getSupportActionBar().setCustomView(R.menu.menu_settings);
        //toolbar.inflateMenu(R.menu.menu_settings);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


}
