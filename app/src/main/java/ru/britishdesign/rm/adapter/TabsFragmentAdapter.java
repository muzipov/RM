package ru.britishdesign.rm.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ru.britishdesign.rm.dto.RemindDTO;
import ru.britishdesign.rm.fragment.AbstractTabFragment;
import ru.britishdesign.rm.fragment.LessonsFragment;
import ru.britishdesign.rm.fragment.RemindersFragment;
import ru.britishdesign.rm.fragment.UU_EventFragment;

public class TabsFragmentAdapter extends FragmentPagerAdapter{

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    private LessonsFragment lessonsFragment;

    private ArrayList<RemindDTO> data;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.data = new ArrayList<>();

        initTabsMap(context);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {

        return tabs.get(position);
    }

    @Override
    public int getCount() {

        return tabs.size();
    }

    private void initTabsMap(Context context) {

        LessonsFragment lessonsFragment = LessonsFragment.getInstance(context, data);

        tabs = new HashMap<>();
        tabs.put(0, lessonsFragment.getInstance(context, data));
        tabs.put(1, RemindersFragment.getInstance(context));
        tabs.put(2, UU_EventFragment.getInstance(context));
    }

    public void setData(ArrayList data) {
        this.data = data;
        lessonsFragment = (LessonsFragment) tabs.get(0);
        lessonsFragment.refreshData(data);
    }
}
