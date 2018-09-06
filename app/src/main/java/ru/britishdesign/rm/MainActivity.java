package ru.britishdesign.rm;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import ru.britishdesign.rm.adapter.TabsFragmentAdapter;
import ru.britishdesign.rm.dto.RemindDTO;

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private TabsFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolBar();
        initNavigationView();
        initTabs();
    }


    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new TabsFragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        new RemindMeTask().execute();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    //навигационная менюшка и фрагменты
    //
    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.actionLessonsItem:
                        showNotificationTab();
                        break;
                    case R.id.actionRemindersItem:
                        showRemindersTab();
                        break;
                    case R.id.actionEventsItem:
                        showEventsTab();
                        break;
                    case R.id.actionSettingsItem:
                        showSettingsLayout();
                        break;
                    case R.id.actionHelpItem:
                        showHelpLayout();
                        break;
                }

                return true;
            }
        });
    }

    private void showNotificationTab() {
        viewPager.setCurrentItem(Constans.TAB_ONE);
    }

    private void showRemindersTab() {
        viewPager.setCurrentItem(Constans.TAB_TWO);
    }

    private void showEventsTab() {
        viewPager.setCurrentItem(Constans.TAB_THREE);
    }

    private void showSettingsLayout() {
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
    }

    private void showHelpLayout(){
        Intent intent = new Intent(MainActivity.this, Help.class);
        startActivity(intent);
    }

    //обращение к серверу
    //
    private class RemindMeTask extends AsyncTask<Void, Void, RemindDTO[]> {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";
        ObjectMapper mapper = new ObjectMapper();
        RemindDTO[] remindDTO;
        private ArrayList dataM = new ArrayList<>();

        private ProgressBar progressBar;

        @Override
        protected void onPreExecute() {
            // [... Обновите индикатор хода выполнения, уведомления или другой
            // элемент пользовательского интерфейса ]

            progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected RemindDTO[] doInBackground(Void... params) {
            //Выполняем в отдельном потоке загрузку

            RestTemplate template = new RestTemplate();
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            ///
            try {
                return template.getForObject(Constans.URL.GET_REMIND_ITEM, RemindDTO[].class);
            } catch (Exception e) {
                return remindDTO;
            }
        }


        protected void onPostExecute(RemindDTO[] remindDTO) {
            // этот метод выполняется в UI потоке
            progressBar.setVisibility(ProgressBar.INVISIBLE);

            ArrayList<RemindDTO[]> data = new ArrayList<>();
            if (remindDTO != null) {

                for (int i = 0; i < remindDTO.length; i++) {
                    dataM.add(remindDTO[i]);
                }
            }
            adapter.setData(dataM);

        }
    }
}