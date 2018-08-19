package ru.britishdesign.rm.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.britishdesign.rm.dto.RemindDTO;
import ru.britishdesign.rm.fragment.AbstractTabFragment;
import ru.britishdesign.rm.fragment.HistoriFragment;
import ru.britishdesign.rm.fragment.RemindersFragment;
import ru.britishdesign.rm.fragment.TodoFragment;
import ru.britishdesign.rm.fragment.UU_EventFragment;

public class TabsFragmentAdapter extends FragmentPagerAdapter{

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    private HistoriFragment historiFragment;

    private List<RemindDTO> data;

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

        HistoriFragment historiFragment = HistoriFragment.getInstance(context, data);

        tabs = new HashMap<>();
        tabs.put(0, historiFragment);
        tabs.put(1, RemindersFragment.getInstance(context));
        tabs.put(2, TodoFragment.getInstance(context));
        tabs.put(3, UU_EventFragment.getInstance(context));
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
        historiFragment.refreshData(data);
    }
}
