package ru.britishdesign.rm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Help extends AppCompatActivity {
    private static final int LAYOUT = R.layout.help;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanseState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanseState);
        setContentView(LAYOUT);

        initToolBar();
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_help);
        // своя навигационная иконка
        // toolbar.setNavigationIcon(R.drawable.magnify);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.help);
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
